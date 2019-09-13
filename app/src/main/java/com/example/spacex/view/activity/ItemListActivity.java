package com.example.spacex.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacex.R;
import com.example.spacex.databinding.ActivityItemListBinding;
import com.example.spacex.model.SpaceXModel;
import com.example.spacex.rxbus.RxBus;
import com.example.spacex.util.Utils;
import com.example.spacex.view.fragment.ItemDetailFragment;
import com.example.spacex.viewmodel.spacexlist.SpaceXViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity implements Consumer<SpaceXModel> {

    ActivityItemListBinding itemListBinding;
    SpaceXViewModel spaceXModel;
    private Disposable eventBusSubscriber;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    public ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemListBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_list);
        spaceXModel = Utils.obtainViewModel(this, SpaceXViewModel.class);
        itemListBinding.setViewModel(spaceXModel);
        itemListBinding.setLifecycleOwner(this);
        Toolbar toolbar = itemListBinding.toolbar;
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading data..");
        dialog.setCancelable(false);
        spaceXModel.dataLoading.observe(this, aBoolean -> {
            if (aBoolean) {
                dialog.show();
            } else
                dialog.dismiss();
        });

        if (itemListBinding.itemListContainer.itemDetailContainer != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        itemListBinding.itemListContainer.itemList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = recyclerView.getLayoutManager().getChildCount();
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                int pastVisibleItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                    spaceXModel.loadNextData();
                }

            }
        });

    }

    @Override
    public void accept(SpaceXModel spaceXModel) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(ItemDetailFragment.ARG_ITEM_ID, spaceXModel);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, ItemDetailActivity.class);
            intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, spaceXModel);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBusSubscriber = RxBus.getInstance().subscribeToBus(this);
        RxBus.getInstance().register(eventBusSubscriber);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (eventBusSubscriber != null) {
            RxBus.getInstance().unregister(eventBusSubscriber);
        }
    }
}

package com.example.spacex.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.example.spacex.R;
import com.example.spacex.databinding.ActivityItemDetailBinding;
import com.example.spacex.model.SpaceXModel;
import com.example.spacex.util.Utils;
import com.example.spacex.view.fragment.ItemDetailFragment;
import com.example.spacex.viewmodel.spacexdetails.SpaceXDetailsViewModel;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {

    ActivityItemDetailBinding activityItemDetailBinding;
    private SpaceXDetailsViewModel spaceXViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityItemDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail);
        spaceXViewModel = Utils.obtainViewModel(this, SpaceXDetailsViewModel.class);
        activityItemDetailBinding.setViewModel(spaceXViewModel);
        activityItemDetailBinding.setLifecycleOwner(this);
        Toolbar toolbar = activityItemDetailBinding.detailToolbar;
        setSupportActionBar(toolbar);

        SpaceXModel spaceXModel = getIntent().getParcelableExtra(ItemDetailFragment.ARG_ITEM_ID);
        spaceXViewModel.setSelectedData(spaceXModel);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();

            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

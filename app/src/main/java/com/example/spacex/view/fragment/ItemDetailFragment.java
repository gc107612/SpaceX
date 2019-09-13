package com.example.spacex.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.spacex.R;
import com.example.spacex.databinding.FragmentItemDetailBinding;
import com.example.spacex.model.SpaceXModel;
import com.example.spacex.util.Utils;
import com.example.spacex.view.activity.ItemDetailActivity;
import com.example.spacex.view.activity.ItemListActivity;
import com.example.spacex.viewmodel.spacexdetails.SpaceXDetailsViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    private FragmentItemDetailBinding fragmentItemDetailBinding;
    private SpaceXDetailsViewModel spaceXViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentItemDetailBinding = FragmentItemDetailBinding.inflate(inflater, container, false);
        Activity activity = getActivity();
        if (activity != null) {
            spaceXViewModel = Utils.obtainViewModel((AppCompatActivity) activity, SpaceXDetailsViewModel.class);
            fragmentItemDetailBinding.setViewModel(spaceXViewModel);
            fragmentItemDetailBinding.setLifecycleOwner(this);
            if (getArguments() != null && getArguments().containsKey(ARG_ITEM_ID)) {
                SpaceXModel spaceXModel = getArguments().getParcelable(ARG_ITEM_ID);
                spaceXViewModel.setSelectedData(spaceXModel);
            }
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(spaceXViewModel.getSelectedData().getMission_name());
            }
        }
        return fragmentItemDetailBinding.getRoot();
    }
}
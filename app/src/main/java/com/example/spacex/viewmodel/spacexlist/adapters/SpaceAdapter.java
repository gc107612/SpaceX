package com.example.spacex.viewmodel.spacexlist.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacex.R;
import com.example.spacex.model.SpaceXModel;
import com.example.spacex.rxbus.RxBus;
import com.example.spacex.util.CustomRecyclerViewAdapter;
import com.example.spacex.util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SpaceAdapter extends CustomRecyclerViewAdapter<SpaceXModel, SpaceAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<SpaceXModel> spaceX_List;
    private int selectedPosition = -1;

    public SpaceAdapter(Context context, ArrayList<SpaceXModel> spaceX_List) {
        this.mContext = context;
        this.spaceX_List = spaceX_List;
    }

    @Override
    public void updateData(@Nullable List<SpaceXModel> data) {
        if (data == null || data.isEmpty()) {
            this.spaceX_List.clear();
        } else {
            this.spaceX_List.addAll(data);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spacex_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        if (selectedPosition == position)
            holder.itemView.setBackgroundColor(mContext.getColor(R.color.colorAccent));
        else
            holder.itemView.setBackgroundColor(mContext.getColor(R.color.white));

        holder.con_layoutMain.setOnClickListener(view -> {
            SpaceXModel spaceXModel = spaceX_List.get(position);
            RxBus.getInstance().postAction(spaceXModel);
            selectedPosition = position;
            notifyDataSetChanged();
        });

        holder.con_layoutMain.setTag(position);

        holder.tv_MissionName.setText(spaceX_List.get(position).getMission_name());
        holder.tv_RocketName.setText(spaceX_List.get(position).getRocket().getRocket_name());
        holder.tv_LaunchSiteName.setText(spaceX_List.get(position).getLaunch_site().getSite_name());

        SimpleDateFormat inputFormat = new SimpleDateFormat(Utils.dateFormatUTC, Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat(Utils.dateFormatYYYYMMDD, Locale.US);
        Date date = null;
        try {
            date = inputFormat.parse(spaceX_List.get(position).getLaunch_date_utc());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedDate = "";

        if (date != null)
            formattedDate = outputFormat.format(date);


        holder.tv_DateOfLaunch.setText(formattedDate);

        Utils.loadImageParticipant(mContext, spaceX_List.get(position).getLinks().getMission_patch_small(), holder.img_launchPathImage);

    }

    @Override
    public int getItemCount() {
        return spaceX_List.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_MissionName;
        private TextView tv_RocketName;
        private TextView tv_LaunchSiteName;
        private TextView tv_DateOfLaunch;
        private ConstraintLayout con_layoutMain;
        private ImageView img_launchPathImage;


        MyViewHolder(View view) {
            super(view);
            con_layoutMain = view.findViewById(R.id.con_layoutMain);
            tv_MissionName = view.findViewById(R.id.tv_MissionName);
            tv_RocketName = view.findViewById(R.id.tv_RocketName);
            tv_LaunchSiteName = view.findViewById(R.id.tv_LaunchSiteName);
            tv_DateOfLaunch = view.findViewById(R.id.tv_DateOfLaunch);
            img_launchPathImage = view.findViewById(R.id.img_launchPathImage);
        }
    }
}
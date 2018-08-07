package com.example.swethababurao.doordashlite.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.swethababurao.doordashlite.Model.RestaurantObject;
import com.example.swethababurao.doordashlite.R;

import java.util.List;

/**
 * Created by swethababurao on 8/6/18.
 */

public class RestuarantAdapter extends RecyclerView.Adapter<RestuarantAdapter.RestaurantViewHolder> {

    private List<RestaurantObject> mRestuarantList;
    private Context mContext;

    public RestuarantAdapter(Context context, List<RestaurantObject> restuarantList) {
        this.mContext = context;
        this.mRestuarantList = restuarantList;
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        private ImageView coverImage;
        private TextView title;
        private TextView description;
        private TextView status;
        private RelativeLayout progressCircle;


        public RestaurantViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            coverImage = (ImageView) mView.findViewById(R.id.iv_logo);
            title = (TextView) mView.findViewById(R.id.tv_title);
            description = (TextView) mView.findViewById(R.id.tv_description);
            status = (TextView) mView.findViewById(R.id.tv_time);
            progressCircle = (RelativeLayout) mView.findViewById(R.id.rl_progresscircle);


        }
    }

    @Override
    public int getItemCount() {
        return mRestuarantList.size();
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.restuarant_list_item, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {

        String title = mRestuarantList.get(position).getName();
        String description = mRestuarantList.get(position).getDescription();
        String status = mRestuarantList.get(position).getStatus();
        String coverImgUrl = mRestuarantList.get(position).getCover_img_url();

        holder.title.setText(title != null ? title : "RestaurantName");
        holder.description.setText(description != null ? description : "Restaurant description");
        holder.status.setText(status != null ? status : "0 mins");
        if (coverImgUrl != null) {
            holder.progressCircle.setVisibility(View.GONE);

            holder.coverImage.setVisibility(View.VISIBLE);

            Glide.with(mContext)
                    .load(coverImgUrl)
                    .centerCrop()
                    //.placeholder(R.drawable.spinner)
                    .into(holder.coverImage);


        }


    }


}

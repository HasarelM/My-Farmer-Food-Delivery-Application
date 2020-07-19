package com.mobile.dev.hasarel.myfarmer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.dev.hasarel.myfarmer.Config.AppConst;
import com.mobile.dev.hasarel.myfarmer.Dto.NavDrawerItem;
import com.mobile.dev.hasarel.myfarmer.Interfaces.OnItemClickListener;
import com.mobile.dev.hasarel.myfarmer.R;

import java.util.Collections;
import java.util.List;

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    private Context mContext;
    private List<NavDrawerItem> mData = Collections.emptyList();
    private OnItemClickListener<NavDrawerItem> mListener;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data, @NonNull OnItemClickListener<NavDrawerItem> listener) {
        this.mContext = context;
        this.mData = data;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public NavigationDrawerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_navigation_drawer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationDrawerAdapter.MyViewHolder holder, int position) {
        NavDrawerItem navigationItem = mData.get(position);
        holder.mTvDrawerItemTitle.setText(navigationItem.getTitle());
        if (navigationItem.getTitle().equals(AppConst.NAV_ITEM_DASHBOARD)) {
            holder.mIvItemIcon.setBackground(mContext.getResources().getDrawable(R.drawable.ic_baseline_dashboard_24));
        } else if (navigationItem.getTitle().equals(AppConst.NAV_ITEM_GLOBAL_SEARCH)) {
            holder.mIvItemIcon.setBackground(mContext.getResources().getDrawable(R.drawable.ic_baseline_search_24));
        } else if (navigationItem.getTitle().equals(AppConst.NAV_ITEM_SYNC_LOG)) {
            holder.mIvItemIcon.setBackground(mContext.getResources().getDrawable(R.drawable.ic_sync_log));
        }else if (navigationItem.getTitle().equals(AppConst.NAV_ITEM_ABOUT)) {
            holder.mIvItemIcon.setBackground(mContext.getResources().getDrawable(R.drawable.ic_about));
        } else if (navigationItem.getTitle().equals(AppConst.NAV_ITEM_Logout)) {
            holder.mIvItemIcon.setBackground(mContext.getResources().getDrawable(R.drawable.ic_logout));
        }

        if (navigationItem.isSelectedItem()) {
            holder.mRlBase.setBackground(mContext.getResources().getDrawable(R.drawable.item_selected_background));
            holder.mTvDrawerItemTitle.setTextColor(mContext.getResources().getColor(R.color.colorSelectedMenuItemText));
        } else {
            holder.mRlBase.setBackground(mContext.getResources().getDrawable(R.drawable.item_click_background));
            holder.mTvDrawerItemTitle.setTextColor(mContext.getResources().getColor(R.color.colorNotSelectedMenuItemText));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mRlBase;
        ImageView mIvItemIcon;
        TextView mTvDrawerItemTitle;

        public MyViewHolder(View view) {
            super(view);

            mRlBase = view.findViewById(R.id.row_navigation_drawer_rl_base);
            mIvItemIcon = view.findViewById(R.id.row_navigation_drawer_iv_item_icon);
            mTvDrawerItemTitle = view.findViewById(R.id.row_navigation_drawer_tv_item_title);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = MyViewHolder.this.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position, mData.get(position));
                    }
                }
            });
        }
    }



}

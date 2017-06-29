package com.example.admin.comicsapp.comics;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.comicsapp.R;
import com.example.admin.comicsapp.dagger.ActivityScope;
import com.example.admin.comicsapp.models.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

@ActivityScope
public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.MyViewHolder> {
    private List<Result> items = new ArrayList<>();
    private final Activity activity;

    @Inject
    public ComicsAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ComicsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_content, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicsAdapter.MyViewHolder holder, int position) {
        if (holder.title != null) {
            holder.title.setText(getItem(position).title);
        }

        String str = getItem(position).thumbnail.path + "." + getItem(position).thumbnail.extension;
        Glide.with(activity)
                .load(str)
                .asBitmap()
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Result> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    private Result getItem(int position) {
        return items.get(position);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;

        @Nullable
        @BindView(R.id.title)
        TextView title;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}



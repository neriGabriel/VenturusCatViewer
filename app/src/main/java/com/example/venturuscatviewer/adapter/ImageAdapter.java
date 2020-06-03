package com.example.venturuscatviewer.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.venturuscatviewer.databinding.ImageItemBinding;
import com.example.venturuscatviewer.model.ImageRequest;
import com.example.venturuscatviewer.util.ImageUtil;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterViewHolder>{

    private List<ImageRequest> imageList;

    public ImageAdapter(List<ImageRequest> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ImageItemBinding imageItemBinding = ImageItemBinding.inflate(layoutInflater, parent, false);

        return new ImageAdapterViewHolder(imageItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterViewHolder holder, int position) {
        ImageUtil.setImageView(this.imageList.get(position).getLink(), holder.imageItemBinding.catImg);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ImageAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageItemBinding imageItemBinding;
        public ImageAdapterViewHolder(@NonNull ImageItemBinding imageItemBinding) {
            super(imageItemBinding.getRoot());
            this.imageItemBinding = imageItemBinding;
        }
    }
}

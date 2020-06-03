package com.example.venturuscatviewer.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

public class ImageUtil {
    public static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.setCenterRadius(50f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

    public static void setImageView(String url, ImageView image) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(getProgressDrawable(image.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .dontAnimate()
                .dontTransform()
                .fitCenter();

        Glide.with(image.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(image);
    }
}

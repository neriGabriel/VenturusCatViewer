package com.example.venturuscatviewer.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
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
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.IMMEDIATE)
                .dontAnimate()
                .dontTransform()
                .encodeFormat(Bitmap.CompressFormat.PNG)
                .format(DecodeFormat.DEFAULT)
                .centerCrop();

        Glide.with(image.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .thumbnail( 0.5f )
                .into(image);
    }
}

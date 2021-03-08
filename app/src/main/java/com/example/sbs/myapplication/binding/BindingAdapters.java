package com.example.sbs.myapplication.binding;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.util.Util;

public class BindingAdapters {
    @BindingAdapter({"numberText"})
    public static void numberText(TextView view, int number) {
        view.setText(number + "");
    }

    @BindingAdapter({"imgUrl"})
    public static void imgUrl(ImageView view, String imgUrl) {
        Util.loadImageOn(imgUrl, view);
    }

    @BindingAdapter({"adapter"})
    public static void imgUrl(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }
}

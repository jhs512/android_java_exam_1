package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewTop = findViewById(R.id.activity_main__imageViewTop);
        Glide.with(this)
                .load("https://picsum.photos/id/981/400/200")
                .transform(new CenterCrop(), new RoundedCorners((int)Util.dipToPixels(10)))
                .into(imageViewTop);

        ImageView imageViewTop2 = findViewById(R.id.activity_main__imageViewTop2);
        Glide.with(this)
                .load("https://i.pravatar.cc/300")
                .transform(new CenterCrop(), new RoundedCorners((int)Util.dipToPixels(150)))
                .into(imageViewTop2);
    }
}
package com.example.venturuscatviewer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.venturuscatviewer.R;
import com.example.venturuscatviewer.adapter.ImageAdapter;
import com.example.venturuscatviewer.databinding.ActivityMainBinding;
import com.example.venturuscatviewer.model.ImageRequest;
import com.example.venturuscatviewer.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;

    private List<ImageRequest> imageList = new ArrayList<>();

    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.getRoot();
        activityMainBinding.setLifecycleOwner(this);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        imageAdapter = new ImageAdapter(imageList);

        activityMainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        activityMainBinding.recyclerView.setAdapter(imageAdapter);

        this.getApiInfo();
    }

    private void getApiInfo() {
        mainActivityViewModel.getApiInfo().observe(activityMainBinding.getLifecycleOwner(), images -> {
            if(images != null) {
                imageList.addAll(images);
                imageAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Não foi possível conectar ao servidor de informações!", Toast.LENGTH_SHORT);
            }
        });
    }
}

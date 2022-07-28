package com.genral9ledge_pro_app.genral9ledge;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.genral9ledge_pro_app.genral9ledge.Model.personModel;
import com.genral9ledge_pro_app.genral9ledge.databinding.ActivityDetailBinding;


public class detailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());

        personModel model = (personModel) getIntent().getSerializableExtra("obj");
        binding.myProfile.setImageResource(model.getGetImage());
        binding.name.setText(model.getName());
    }
}
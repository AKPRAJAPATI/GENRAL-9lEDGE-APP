package com.genral9ledge_pro_app.genral9ledge.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.databinding.FragmentDeveloperBinding;

public class DeveloperFragment extends Fragment {

FragmentDeveloperBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentDeveloperBinding.inflate(inflater,container,false);
        Typeface typeface = ResourcesCompat.getFont(getContext(),R.font.hand_writing);
        binding.name.setTypeface(typeface);
        binding.description.setTypeface(typeface);
        binding.gmail.setTypeface(typeface);
        binding.phone.setTypeface(typeface);
        binding.signingText.setTypeface(typeface);



      return  binding.getRoot();
    }
}
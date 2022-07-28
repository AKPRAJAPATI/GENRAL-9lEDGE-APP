package com.genral9ledge_pro_app.genral9ledge.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.genral9ledge_pro_app.genral9ledge.R;


public class privacyFragment extends Fragment {

         @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_privacy, container, false);

             String url = "https://pages.flycricket.io/genral-9ledge-0/privacy.html";
             WebView web = (WebView) view.findViewById(R.id.webview);

             web.getSettings().setJavaScriptEnabled(true);
             web.getSettings().setLoadWithOverviewMode(true);
             web.getSettings().setUseWideViewPort(true);
             web.getSettings().setBuiltInZoomControls(true);
             web.getSettings().setPluginState(WebSettings.PluginState.ON);
             web.setWebViewClient(new WebViewClient());

             web.loadUrl(url);

         return  view;

         }
}
package com.genral9ledge_pro_app.genral9ledge.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.genral9ledge_pro_app.genral9ledge.Model.personModel;
import com.genral9ledge_pro_app.genral9ledge.Model.rajpalModel;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.adapter.rajpalAdapter;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.FragmentRajyaPalBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;

public class rajyaPalFragment extends Fragment implements callBack {
    private FragmentRajyaPalBinding binding;

    Activity activity;
    int counter;
    private RewardedAd mRewardedAd;
    AdRequest adRequest;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRajyaPalBinding.inflate(inflater,container,false);
        adRequest = new AdRequest.Builder().build();
        activity = getActivity();
        setAds();
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setHasFixedSize(true);
        ArrayList<rajpalModel> arrayList = new ArrayList<>();

        arrayList.add(new rajpalModel(R.drawable.india6, "ब्रिगेडियर बीडी मिश्रा","अरुणाचल प्रदेश","03 अक्टूबर 2017"));
        arrayList.add(new rajpalModel(R.drawable.india6, "जगदीश मुखी","असम","10 अक्टूबर 2017"));
        arrayList.add(new rajpalModel(R.drawable.india6, "बिस्वा भूषण हरिचंदन","आन्ध्र प्रदेश","16 जुलाई 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "आनंदीबेन पटेल","उत्तर प्रदेश","20 जुलाई 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "गुरमीत सिंह","उत्तराखण्ड","10 सितम्बर 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "प्रो. गणेश लाल","ओडिशा","29 मई 2018"));
        arrayList.add(new rajpalModel(R.drawable.india6, "थावर चंद गहलोत","कर्नाटक","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "आरिफ मोहम्मद खान","केरल","01 सितम्बर 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "आचार्य देव व्रत","गुजरात","15 जुलाई 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "पीएस श्रीधरन पिल्लई","गोवा","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "अनुसुइया उइके","छत्तीसगढ","16 जुलाई 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "रमेश बैस","झारखण्ड","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "आर एन रवि","तमिलनाडु","10 सितम्बर 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "डॉक्टर तमिलिसाई सौंदरराजन","तेलंगाना","01 सितम्बर 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "सत्यदेव नारायण आर्य","त्रिपुरा","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "प्रोफेसर जगदीश मुखी","नागालैण्ड","अतिरिक्त प्रभार"));
        arrayList.add(new rajpalModel(R.drawable.india6, "बनवारीलाल पुरोहित","पंजाब","10 सितम्बर 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "जगदीप धनखड़","पश्चिम बंगाल","20 जुलाई 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "फागु चौहान","बिहार","20 जुलाई 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "इला गणेशन","मणिपुर","22 अगस्त 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "मंगूभाई छगनभाई पटेल","मध्य प्रदेश","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "भगतसिंह कोश्यारी","महाराष्ट्र","01 सितम्बर 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "हरि बाबू कंभमपति","मिज़ोरम","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "सत्यपाल मलिक","मेघालय","18 अगस्त 2020"));
        arrayList.add(new rajpalModel(R.drawable.india6, "कलराज मिश्र","राजस्थान","01 सितम्बर 2019"));
        arrayList.add(new rajpalModel(R.drawable.india6, "गंगा प्रसाद","सिक्किम","21 अगस्त 2018"));
        arrayList.add(new rajpalModel(R.drawable.india6, "बंडारू दत्तात्रेय","हरियाणा","06 जुलाई 2021"));
        arrayList.add(new rajpalModel(R.drawable.india6, "राजेंद्रन विश्वनाथ अर्लेकर","हिमाचल प्रदेश","06 जुलाई 2021"));

        binding.recyclerview.setAdapter(new rajpalAdapter(getActivity(),arrayList,this));
        return  binding.getRoot();
    }

    private void setAds() {
        RewardedAd.load(getContext(), "ca-app-pub-9898269998695494/8828045691", adRequest, new RewardedAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error.
                mRewardedAd = null;

            }

            @Override
            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                mRewardedAd = rewardedAd;
            }
        });

    }

    @Override
    public void clickcked(int position) {
        if (mRewardedAd != null) {
            mRewardedAd.show(activity, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdClicked() {
                            super.onAdClicked();
                            mRewardedAd = null;
                            setAds();
                        }
                    });
                }
            });
        } else {
            mRewardedAd = null;
            setAds();
        }
        mRewardedAd = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        new CountDownTimer(110000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counter++;
            }

            @Override
            public void onFinish() {
                setAds();
            }
        }.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                if (mRewardedAd != null) {
                    mRewardedAd.show(activity, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                            mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                    mRewardedAd = null;
                                    setAds();
                                }
                            });
                        }
                    });
                } else {
                    mRewardedAd = null;
                    setAds();
                }
                mRewardedAd = null;

            }
        }, delay);
        super.onResume();
    }

    @Override
    public void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();

    }
}
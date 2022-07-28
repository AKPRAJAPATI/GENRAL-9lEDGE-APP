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

import com.genral9ledge_pro_app.genral9ledge.Model.Country;
import com.genral9ledge_pro_app.genral9ledge.Model.personModel;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.adapter.countryAdapter;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.FragmentRajyaRajdhaniBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;


public class rajya_rajdhaniFragment extends Fragment implements callBack {
 private FragmentRajyaRajdhaniBinding binding;

    private ArrayList<personModel> arrayList;
    Activity activity;
    int counter;
    private RewardedAd mRewardedAd;
    AdRequest adRequest;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRajyaRajdhaniBinding.inflate(inflater,container,false);
        adRequest = new AdRequest.Builder().build();
        activity = getActivity();
        setAds();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setHasFixedSize(true);
        ArrayList<Country> arrayList = new ArrayList<>();
        MY_ARRAYLIST(arrayList);
        binding.recyclerview.setAdapter(new countryAdapter(getActivity(),arrayList,this));

        return  binding.getRoot();
    }

    private void MY_ARRAYLIST(ArrayList<Country> arrayList) {
        arrayList.add(new Country(R.drawable.india6,"आंध्रप्रदेश","अमरावती"));
        arrayList.add(new Country(R.drawable.india6,"अरुणाचल प्रदेश","ईटानगर"));
        arrayList.add(new Country(R.drawable.india6,"असम","दिसपुर"));
        arrayList.add(new Country(R.drawable.india6,"बिहार","पटना"));
        arrayList.add(new Country(R.drawable.india6,"छत्तीसगढ़","रायपुर"));
        arrayList.add(new Country(R.drawable.india6,"गोवा","पणजी"));
        arrayList.add(new Country(R.drawable.india6,"गुजरात","गांधी नगर"));
        arrayList.add(new Country(R.drawable.india6,"हरियाणा","चण्डीगढ़"));
        arrayList.add(new Country(R.drawable.india6,"हिमाचल प्रदेश","शिमला"));
        arrayList.add(new Country(R.drawable.india6,"झारखंड","रांची"));
        arrayList.add(new Country(R.drawable.india6,"कर्नाटक","बेंगलुरु"));
        arrayList.add(new Country(R.drawable.india6,"केरल","तिरुवनंतपुरम"));
        arrayList.add(new Country(R.drawable.india6,"मध्य प्रदेश","भोपाल"));
        arrayList.add(new Country(R.drawable.india6,"महाराष्ट्र","मुंबई"));
        arrayList.add(new Country(R.drawable.india6,"मणिपुर","इम्फाल"));
        arrayList.add(new Country(R.drawable.india6,"मेघालय","शिलोंग"));
        arrayList.add(new Country(R.drawable.india6,"मिज़ोरम","आइज़ोल"));
        arrayList.add(new Country(R.drawable.india6,"नागालैंड","कोहिमा"));
        arrayList.add(new Country(R.drawable.india6,"ओडिशा","भुवनेश्वर"));
        arrayList.add(new Country(R.drawable.india6,"पंजाब","चण्डीगढ़"));
        arrayList.add(new Country(R.drawable.india6,"राजस्थान","जयपुर"));
        arrayList.add(new Country(R.drawable.india6,"सिक्किम","गैंगटोक"));
        arrayList.add(new Country(R.drawable.india6,"तमिलनाडु","चेन्नई"));
        arrayList.add(new Country(R.drawable.india6,"तेलंगाना","हैदराबाद"));
        arrayList.add(new Country(R.drawable.india6,"त्रिपुरा","अगरतला"));
        arrayList.add(new Country(R.drawable.india6,"उत्तरप्रदेश","लखनऊ"));
        arrayList.add(new Country(R.drawable.india6,"उत्तराखंड","देहरादून"));
        arrayList.add(new Country(R.drawable.india6,"पश्चिम बंगाल","कोलकाता"));
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
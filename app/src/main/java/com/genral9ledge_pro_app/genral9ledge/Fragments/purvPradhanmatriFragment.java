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
import com.genral9ledge_pro_app.genral9ledge.Model.purvPradhanMantri;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.adapter.purv_personAdapter;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.FragmentPurvPradhanmatriBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


import java.util.ArrayList;

public class purvPradhanmatriFragment extends Fragment implements callBack {
    private FragmentPurvPradhanmatriBinding binding;
    private ArrayList<purvPradhanMantri> arrayList;
    Activity activity;
    int counter;
    private RewardedAd mRewardedAd;
    AdRequest adRequest;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPurvPradhanmatriBinding.inflate(inflater,container,false);
        adRequest = new AdRequest.Builder().build();
        activity = getActivity();
        setAds();
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setHasFixedSize(true);
        ArrayList<purvPradhanMantri> arrayList = new ArrayList<>();
        MY_ARRAYLIST(arrayList);
        binding.recyclerview.setAdapter(new purv_personAdapter(getActivity(),arrayList,this));

        return  binding.getRoot();
    }

    private void MY_ARRAYLIST(ArrayList<purvPradhanMantri> arrayList) {
        arrayList.add(new purvPradhanMantri(R.drawable.jawahar_lal,"जवाहर लाल नेहरू","15 अगस्त 1947 से 27 मई 1964" ));
        arrayList.add(new purvPradhanMantri(R.drawable.guljari_lal,"गुलजारी लाल नंदा","27 मई 1964 से ९ जून 1964" ));
        arrayList.add(new purvPradhanMantri(R.drawable.lal_bahadur,"लाल बहादुर शास्त्री","9 जून 1964 से 11 जनवरी 1966" ));
        arrayList.add(new purvPradhanMantri(R.drawable.guljari_lal,"गुलजारी लाल नंदा","11 जनवरी 1966 से 24 जनवरी 1966" ));
        arrayList.add(new purvPradhanMantri(R.drawable.indira_gandhi,"इंदिरा गाँधी","24 जनवरी 1966 से 24 मार्च 1977" ));
        arrayList.add(new purvPradhanMantri(R.drawable.maraja_raji,"मोरारजी देसाई","24 मार्च 1977 से 28 जुलाई 1979" ));
        arrayList.add(new purvPradhanMantri(R.drawable.charan_singh,"चंरण सिंह","28 जुलाई 1979 to 14 जनवरी 1980" ));
        arrayList.add(new purvPradhanMantri(R.drawable.indira_gandhi,"इंदिरा गाँधी","14 जनवरी 1980 से 31 अक्टूबर 1984"));
        arrayList.add(new purvPradhanMantri(R.drawable.rajiv_gandhi,"राजीव गाँधी","31 अक्टूबर 1984 to 2 दिसम्बर 1989"));
        arrayList.add(new purvPradhanMantri(R.drawable.vishwa_nath,"वी पी सिंह","2 दिसम्बर 1989 to 10 नवम्बर 1990" ));
        arrayList.add(new purvPradhanMantri(R.drawable.chandra_shekhar,"चन्द्र शेखर","10 नवम्बर 1990 to 21 जून 1991" ));
        arrayList.add(new purvPradhanMantri(R.drawable.pv_narshimha_rao,"पी वी सिंह","21 जून 1991 to 16 मई 1996 " ));
        arrayList.add(new purvPradhanMantri(R.drawable.atal_vihari,"अटल विहारी बाजपेयी","16 मई 1996 to 1 जून 1996" ));
        arrayList.add(new purvPradhanMantri(R.drawable.hd_deve_gowda,"अच् डी देवे गोवडा","1 जून 1996 to 21 अप्रैल 1997"));
        arrayList.add(new purvPradhanMantri(R.drawable.inder_kumar,"इन्दर  कुमार","21 अप्रिल 1997 to 19 मार्च 1998 "));
        arrayList.add(new purvPradhanMantri(R.drawable.atal_vihari,"अटल विहारी बाजपेयी","19 मार्च 1998 to 22 मई 2004 " ));
        arrayList.add(new purvPradhanMantri(R.drawable.man_mohansingh,"मनमोहर सिंह","22 मई 2004 to 26 मई 2014   " ));

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

//    @Override
//    public void onitemClicked(int position, ImageView profile, TextView name) {
//
//        Intent intent = new Intent(getContext(), detailActivity.class);
//        intent.putExtra("obj", arrayList.get(position));
//        Pair<View, String> p1 = Pair.create((View) profile, "profile");
//        Pair<View, String> p2 = Pair.create((View) name, "name");
//        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), p1, p2);
//        startActivity(intent, optionsCompat.toBundle());
//
//    }

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
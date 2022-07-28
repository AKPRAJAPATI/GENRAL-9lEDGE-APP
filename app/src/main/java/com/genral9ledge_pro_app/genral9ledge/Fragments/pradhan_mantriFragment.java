package com.genral9ledge_pro_app.genral9ledge.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.genral9ledge_pro_app.genral9ledge.Model.personModel;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.adapter.MainAdapter;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.FragmentPradhanMantriBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;

public class pradhan_mantriFragment extends Fragment implements callBack {
    private FragmentPradhanMantriBinding binding;
    private ArrayList<personModel> arrayList;
    Activity activity;
    int counter;
    private RewardedAd mRewardedAd;
    AdRequest adRequest;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, Bundle savedInstanceState) {
        binding = FragmentPradhanMantriBinding.inflate(layoutInflater, parent, false);
        adRequest = new AdRequest.Builder().build();
        activity = getActivity();
        setAds();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerview.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        MY_ARRAYLIST(arrayList);
        binding.recyclerview.setAdapter(new MainAdapter(getActivity(), arrayList, this));
        return binding.getRoot();
    }

    //THIS IS MY ALL THE ARRAYLIST
    private void MY_ARRAYLIST(ArrayList<personModel> arrayList) {
        arrayList.add(new personModel(R.drawable.jawahar_lal, "1st", "जवाहर लाल नेहरू", "15 अगस्त 1947 से 27 मई 1964", "16 साल , 286 दिन"));
        arrayList.add(new personModel(R.drawable.guljari_lal, "2nd", "गुलजारी लाल नंदा", "27 मई 1964 से ९ जून 1964", "13 दिन"));
        arrayList.add(new personModel(R.drawable.lal_bahadur, "3rd", "लाल बहादुर शास्त्री", "9 जून 1964 से 11 जनवरी 1966", "1 साल 216 दिन"));
        arrayList.add(new personModel(R.drawable.guljari_lal, "4th", "गुलजारी लाल नंदा", "11 जनवरी 1966 से 24 जनवरी 1966", "13 दिन"));
        arrayList.add(new personModel(R.drawable.indira_gandhi, "5th", "इंदिरा गाँधी", "24 जनवरी 1966 से 24 मार्च 1977", "11 साल 59 दिन"));
        arrayList.add(new personModel(R.drawable.maraja_raji, "6th", "मोरारजी देसाई", "24 मार्च 1977 से 28 जुलाई 1979", "2 साल 126 दिन"));
        arrayList.add(new personModel(R.drawable.charan_singh, "7th", "चंरण सिंह", "28 जुलाई 1979 to 14 जनवरी 1980", "170 दिन"));
        arrayList.add(new personModel(R.drawable.indira_gandhi, "8th", "इंदिरा गाँधी", "14 जनवरी 1980 से 31 अक्टूबर 1984", "4 सालs, 291 दिन"));
        arrayList.add(new personModel(R.drawable.rajiv_gandhi, "9th", "राजीव गाँधी", "31 अक्टूबर 1984 to 2 दिसम्बर 1989", "5 साल, 32 दिन"));
        arrayList.add(new personModel(R.drawable.vishwa_nath, "10th", "वी पी सिंह", "2 दिसम्बर 1989 to 10 नवम्बर 1990", "343 दिन"));
        arrayList.add(new personModel(R.drawable.chandra_shekhar, "11ve", "चन्द्र शेखर", "10 नवम्बर 1990 to 21 जून 1991", "223 दिन"));
        arrayList.add(new personModel(R.drawable.pv_narshimha_rao, "12ve", "पी वी सिंह", "21 जून 1991 to 16 मई 1996 ", "4 साल, 330 दिन"));
        arrayList.add(new personModel(R.drawable.atal_vihari, "13en", "अटल विहारी बाजपेयी", "16 मई 1996 to 1 जून 1996", "16 दिन"));
        arrayList.add(new personModel(R.drawable.hd_deve_gowda, "14en", "अच् डी देवे गोवडा", "1 जून 1996 to 21 अप्रैल 1997", "324 दिन"));
        arrayList.add(new personModel(R.drawable.inder_kumar, "15en", "इन्दर  कुमार", "21 अप्रिल 1997 to 19 मार्च 1998 ", "332 दिन"));
        arrayList.add(new personModel(R.drawable.atal_vihari, "16en", "अटल विहारी बाजपेयी", "19 मार्च 1998 to 22 मई 2004 ", "6 साल, 64 दिन"));
        arrayList.add(new personModel(R.drawable.man_mohansingh, "17en", "मनमोहर सिंह", "22 मई 2004 to 26 मई 2014   ", "10 साल, 4 दिन"));
        arrayList.add(new personModel(R.drawable.narendra, "18en", "नरेन्द्र मोदी", "26 मई 2014 से  ", "अब तक"));

    }

    private void setAds() {
        RewardedAd.load(getActivity(), "ca-app-pub-9898269998695494/8828045691", adRequest, new RewardedAdLoadCallback() {
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
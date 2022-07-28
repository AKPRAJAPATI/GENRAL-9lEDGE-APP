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
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.adapter.MainAdapter;
import com.genral9ledge_pro_app.genral9ledge.adapter.personAdapter;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.FragmentCheapMinisterBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;

public class cheap_ministerFragment extends Fragment implements callBack {
    private FragmentCheapMinisterBinding binding;
    Activity activity;
    int counter;
    private RewardedAd mRewardedAd;
    AdRequest adRequest;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCheapMinisterBinding.inflate(inflater,container,false);
        adRequest = new AdRequest.Builder().build();
        activity = getActivity();
        setAds();


        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setHasFixedSize(true);
        ArrayList<personModel> arrayList = new ArrayList<>();
        MY_ARRAYLIST(arrayList);


        binding.recyclerview.setAdapter(new MainAdapter(getActivity(),arrayList,this));
        return  binding.getRoot();
    }

    private void MY_ARRAYLIST(ArrayList<personModel> arrayList) {
        arrayList.add(new personModel(R.drawable.ic_launcher_background,getString(R.string.first), "सर नवाब मुहम्मद अहमद सईद खॉं","03-04-1937 से 16-07-1937","--"));
        arrayList.add(new personModel(R.drawable.govind,getString(R.string.second),"पंडित गोविन्द वल्लभ पंत","26 जनवरी 1950 से 27 दिसंबर 1954","4 वर्ष, 335 दिन"));
        arrayList.add(new personModel(R.drawable.chandrabhanu,getString(R.string.fourth),"चंद्रभानु गुप्ता","7 दिसंबर 1960 से 1 अक्टूबर 1963","2 वर्ष, 298 दिन"));
        arrayList.add(new personModel(R.drawable.sampurnanand,getString(R.string.third),"संपूर्णानंद","28 दिसम्बर 1954 से 6 दिसम्बर 1960","5 वर्ष, 344 दिन"));
        arrayList.add(new personModel(R.drawable.suchelata,getString(R.string.fifth),"सुचेता कृपलानी","2 अक्टूबर 1963 से 13 मार्च 1967","3 वर्ष, 162 दिन"));
        arrayList.add(new personModel(R.drawable.chandrabhanu,getString(R.string.sixth),"चंद्रभानु गुप्ता","14 मार्च 1967 से 2 अप्रैल 1967","19 दिन"));
        arrayList.add(new personModel(R.drawable.charan_singh,getString(R.string.seventh)," चौधरी चरण सिंह","3 अप्रैल 1967 से 25 फरवरी 1968","328 दिन"));
        arrayList.add(new personModel(R.drawable.chandrabhanu,getString(R.string.eight),"चंद्रभानु गुप्ता","26 फरवरी 1969 से 17 फरवरी 1970","356 दिन"));
        arrayList.add(new personModel(R.drawable.charan_singh,getString(R.string.nineth),"चौधरी चरण सिंह","18 फरवरी 1970 से 1 अक्टूबर 1970","225 दिन"));
        arrayList.add(new personModel(R.drawable.tribhuvan,getString(R.string.tenth),"त्रिभुवन नारायण सिंह","18 अक्टूबर 1970 से 3 अप्रैल 1971","167 दिन"));
        arrayList.add(new personModel(R.drawable.kamlapati,getString(R.string.eleventh),"कमलापति त्रिपाठी","4 अप्रैल 1971 से 12 जून 1973","2 वर्ष, 69 दिन"));
        arrayList.add(new personModel(R.drawable.hemvati,getString(R.string.twelveth),"हेमवतीनंदन बहुगुणा","9 नवंबर 1973 से 29 नवंबर 1975","2 वर्ष, 21 दिन"));
        arrayList.add(new personModel(R.drawable.narayan_datt,getString(R.string.thirteen),"नारायण दत्त तिवारी","22 जनवरी 1976 से 30 अप्रैल 1977","1 वर्ष, 99 दिन"));
        arrayList.add(new personModel(R.drawable.ram_naresh,getString(R.string.forteen),"राम नरेश यादव","23 जून 1977 से 27 फरवरी 1979","1 वर्ष, 249 दिन"));
        arrayList.add(new personModel(R.drawable.babubanarasidas,getString(R.string.fifteen),"बनारसी दासी","28 फरवरी 1979 से 17 फरवरी 1980","354 दिन"));
        arrayList.add(new personModel(R.drawable.vishwa_nath,getString(R.string.sixteen)," विश्वनाथ प्रताप सिंह","9 जून 1980 से 18 जुलाई 1982","2 वर्ष, 39 दिन"));
        arrayList.add(new personModel(R.drawable.shripati,getString(R.string.seventeen),"श्रीपति मिश्रा","19 जुलाई 1982 से 2 अगस्त 1984","2 वर्ष, 14 दिन"));
        arrayList.add(new personModel(R.drawable.narayan_datt,getString(R.string.eighteen),"नारायण दत्त तिवारी","3 अगस्त 1984 से 24 सितंबर 1985","1 वर्ष, 52 दिन"));
        arrayList.add(new personModel(R.drawable.vir_bahadur,getString(R.string.nineteen),"वीर बहादुर सिंह","24 सितंबर 1985 से 24 जून 1988","2 वर्ष, 274 दिन"));
        arrayList.add(new personModel(R.drawable.narayan_datt,getString(R.string.twenty),"नारायण दत्त तिवारी","25 जून 1988 से 5 दिसंबर 1989","1 वर्ष, 163 दिन"));
        arrayList.add(new personModel(R.drawable.mulayam,getString(R.string.twelve1),"मुलायम सिंह यादव","5 दिसंबर 1989 से 24 जून 1991","1 वर्ष, 201 दिन"));
        arrayList.add(new personModel(R.drawable.kalyan,getString(R.string.twelve2),"कल्याण सिंह","24 जून 1991 से 6 दिसंबर 1992","1 वर्ष, 165 दिन"));
        arrayList.add(new personModel(R.drawable.mulayam,getString(R.string.twelve3),"मुलायम सिंह यादव","4 दिसंबर 1993 से 3 जून 1995","1 वर्ष, 181 दिन"));
        arrayList.add(new personModel(R.drawable.mayavati,getString(R.string.twelve4),"मायावती","3 जून 1995 से 18 अक्टूबर 1995","137 दिन"));
        arrayList.add(new personModel(R.drawable.mayavati,getString(R.string.twelve5),"मायावती","21 मार्च 1997 से 21 सितंबर 1997","184 दिन"));
        arrayList.add(new personModel(R.drawable.kalyan,getString(R.string.twelve6),"कल्याण सिंह","21 सितंबर 1997 से 12 सितंबर 1999","2 वर्ष, 52 दिन"));
        arrayList.add(new personModel(R.drawable.ram_prakash,getString(R.string.twelve7),"रामप्रकाश गुप्ता","12 नवंबर 1999 से 28 अक्टूबर 2000","351 दिन"));
        arrayList.add(new personModel(R.drawable.rajnath,getString(R.string.twelve8),"राजनाथ सिंह","28 अक्टूबर 2000 से 8 मार्च 2002","1 वर्ष, 131 दिन"));
        arrayList.add(new personModel(R.drawable.mayavati,getString(R.string.twelve9),"मायावती","3 मई 2002 से 29 अगस्त 2003","1 वर्ष, 118 दिन"));
        arrayList.add(new personModel(R.drawable.mulayam,getString(R.string.thirty),"मुलायम सिंह यादव","29 अगस्त 2003 से 13 मई 2007","3 वर्ष, 257 दिन"));
        arrayList.add(new personModel(R.drawable.mayavati,getString(R.string.thirty1),"मायावती","13 मई 2007 से 7 मार्च 2012","4 वर्ष, 360 दिन"));
        arrayList.add(new personModel(R.drawable.akhilesh,getString(R.string.thirty2),"अखिलेश यादव","15 मार्च 2012 से 11 मार्च 2017","5 वर्ष, 4 दिन"));
        arrayList.add(new personModel(R.drawable.adityanath,getString(R.string.thirty3),"योगी आदित्यनाथ","25-03-2022 से वर्तमान"," 5 वर्ष, 124 दिन और निरंतर"));


    }

    private void setAds() {
        RewardedAd.load(activity,"ca-app-pub-9898269998695494/8828045691", adRequest, new RewardedAdLoadCallback() {
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
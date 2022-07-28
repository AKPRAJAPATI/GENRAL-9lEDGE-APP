package com.genral9ledge_pro_app.genral9ledge.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.genral9ledge_pro_app.genral9ledge.Model.Country;
import com.genral9ledge_pro_app.genral9ledge.Model.rajpalModel;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.CountryItemBinding;
import com.genral9ledge_pro_app.genral9ledge.databinding.LayoutAdBinding;
import com.genral9ledge_pro_app.genral9ledge.databinding.RajyaparlItemBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.ArrayList;

public class rajpalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW = 0;
    private static final int AD_VIEW = 1;
    private static final int ITEM_FEED_COUNT = 5;
    private final Activity activity;
    private final ArrayList<rajpalModel> mainList;
    private callBack callback;

    public rajpalAdapter(Activity activity, ArrayList<rajpalModel> mainList, callBack callback) {
        this.activity = activity;
        this.mainList = mainList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        if (viewType == ITEM_VIEW) {
            View view = layoutInflater.inflate(R.layout.rajyaparl_item, parent, false);
            return new rajpalAdapter.MainViewHolder(view);
        } else if (viewType == AD_VIEW) {
            View view = layoutInflater.inflate(R.layout.layout_ad, parent, false);
            return new rajpalAdapter.AdViewHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_VIEW) {
            int positions = holder.getAdapterPosition();
            int pos = position - Math.round(position / ITEM_FEED_COUNT);
            ((rajpalAdapter.MainViewHolder) holder).bindData(mainList.get(pos),positions);
        } else if (holder.getItemViewType() == AD_VIEW) {
            ((rajpalAdapter.AdViewHolder) holder).bindAdData();
        }

    }

    @Override
    public int getItemCount() {
        if (mainList.size() > 0) {
            return mainList.size() + Math.round(mainList.size() / ITEM_FEED_COUNT);
        }
        return mainList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if ((position + 1) % ITEM_FEED_COUNT == 0) {
            return AD_VIEW;
        }
        return ITEM_VIEW;
    }

    private void populateNativeADView(NativeAd nativeAd, NativeAdView adView) {
        // Set the media view.

        //adView.setMediaView(adView.findViewById(R.id.ad_media));

        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline and mediaContent are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        // adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd);
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        RajyaparlItemBinding binding;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RajyaparlItemBinding.bind(itemView);
        }
        private void bindData(rajpalModel main, int positions) {
            binding.indiaImage.setImageResource(main.getImage());
            binding.name.setText(main.getName());
            binding.kabSeKabTak.setText(main.getRajya());
            binding.kitaneSal.setText(main.getTime());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.clickcked(positions);
                }
            });
        }
    }

    public class AdViewHolder extends RecyclerView.ViewHolder {

        LayoutAdBinding binding;

        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = LayoutAdBinding.bind(itemView);
        }
        private void bindAdData() {
            AdLoader.Builder builder = new AdLoader.Builder(activity, "ca-app-pub-9898269998695494/5336071981")
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                            NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.local, null);
                            populateNativeADView(nativeAd, nativeAdView);
                            binding.adLayout.removeAllViews();
                            binding.adLayout.addView(nativeAdView);
                        }
                    });

            AdLoader adLoader = builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Toast.makeText(activity, loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).build();

            adLoader.loadAd(new AdRequest.Builder().build());
        }
    }
}

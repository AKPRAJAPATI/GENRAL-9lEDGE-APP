package com.genral9ledge_pro_app.genral9ledge.adapter;

import android.app.Activity;
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

import com.genral9ledge_pro_app.genral9ledge.Model.personModel;
import com.genral9ledge_pro_app.genral9ledge.R;
import com.genral9ledge_pro_app.genral9ledge.callBack;
import com.genral9ledge_pro_app.genral9ledge.databinding.LayoutAdBinding;
import com.genral9ledge_pro_app.genral9ledge.databinding.PersonItemBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.ArrayList;

public class person2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_VIEW = 0;
    private static final int AD_VIEW = 1;
    private static final int ITEM_FEED_COUNT = 2;
    private final Activity activity;
    private ArrayList<personModel> arrayList;
    private callBack callback;

    public person2Adapter(Activity activity, ArrayList<personModel> arrayList, callBack callback) {
        this.activity = activity;
        this.arrayList = arrayList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW) {
            return new myViewHolder(LayoutInflater.from(activity).inflate(R.layout.person_item, parent, false));
        } else if (viewType == AD_VIEW) {
            return new myViewHolder(LayoutInflater.from(activity).inflate(R.layout.layout_ad, parent, false));
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_VIEW) {
            int posiSion = holder.getAdapterPosition();
            int pos = position - Math.round(position / ITEM_FEED_COUNT);
            ((myViewHolder) holder).bindData(arrayList.get(pos),posiSion);


        } else if (holder.getItemViewType() == AD_VIEW) {
            ((adViewHolder) holder).bindAdData();
        }
    }

    @Override
    public int getItemCount() {
        if (arrayList.size() > 0) {
            return arrayList.size() + Math.round(arrayList.size() / ITEM_FEED_COUNT);
        }
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if ((position + 1) % ITEM_FEED_COUNT == 0) {
            return AD_VIEW;
        }
        return ITEM_VIEW;
    }


    public class adViewHolder extends RecyclerView.ViewHolder {
        private LayoutAdBinding binding;
        public adViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = LayoutAdBinding.bind(itemView);
        }
        private void bindAdData() {
            AdLoader.Builder builder = new AdLoader.Builder(activity, "ca-app-pub-9898269998695494/5336071981")
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                            NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.layout_native_ad, null);
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

    private void populateNativeADView(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView(adView.findViewById(R.id.ad_media));

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
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

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

    public class myViewHolder extends RecyclerView.ViewHolder {
        private PersonItemBinding binding;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PersonItemBinding.bind(itemView);
        }
        private void bindData(personModel main, int posiSion) {

            binding.positionCount.setText(main.getFirst_secondNumber());
            binding.myProfile.setImageResource(main.getGetImage());
             binding.name.setText(main.getName());
             binding.kabSeKabTak.setText(main.getKab_se_kab_tak());
             binding.kitaneSal.setText(main.getKitane_din());

        }
    }
}

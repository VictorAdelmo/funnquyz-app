package com.example.yeah.methods;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.yeah.R;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

import java.util.ArrayList;
import java.util.List;

public class Videos {

    public void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
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
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }

    public List<String> mostrarVideosEngraçados(){

        List<String> lista = new ArrayList<>();

        lista.add("5DDZ56xFlFE");
        lista.add("yED8dW2ZhUk");
        lista.add("YcWyap30b20");
        lista.add("vd58GttSfUQ");
        lista.add("GsG084_bKM4");
        lista.add("iYyrHknQjw8");
        lista.add("eIBkVjj4jpE");
        lista.add("sMxJNL4_Y7E");
        lista.add("L1Tcu8KFgTg");
        lista.add("YJ9rWpXbxiE");
        lista.add("rIFxRumDv4Y");
        lista.add("DtgLzEm9FzY");
        lista.add("aRvMqjuq0TA");
        lista.add("Lzk6jNW0oaA");
        lista.add("cx_o8KxfeZ4");
        lista.add("xdU4bjOGpbg");
        lista.add("2F6jaljvvrI");
        lista.add("uZUAZO0tnIU");
        lista.add("t5boF_kvR-w");
        lista.add("Lu3P-2XksG4");
        lista.add("OLAKpJ3dTqQ");
        lista.add("S8DPIOPRR7c");
        lista.add("2j-_mASP9_M");
        lista.add("M5vdW0ys274");
        lista.add("WHrw3eQffhY");
        lista.add("da0XqplJuKA");
        lista.add("mw_plwigajw");
        lista.add("BK31qCQtYdo");
        lista.add("bhXGy_86r-Q");
        lista.add("5XxDE-ZSgX8");
        lista.add("70XHRlLIqNo");
        lista.add("1pB9oJyt3ik");
        lista.add("R7ghF_6zq3Q");
        lista.add("YoWxPlkKT_0");
        lista.add("rB8OfpViI2k");
        lista.add("I-FkkViu5cs");
        lista.add("JDnTS1rihrI");
        lista.add("1uZ492nvGBo");
        lista.add("pJh90Jvh28o");
        lista.add("u2zbz4RVMxw");
        lista.add("BG8To3l3YYU");
        lista.add("s80YzNB70Qw");
        lista.add("9QGu2w03C2A");
        lista.add("m8-KupQ9bYI");
        lista.add("yZtPf_kNEHc");
        lista.add("ebxOtrWiST8");
        lista.add("FaTKqJVDesc");
        lista.add("0t--Nxn5Vj0");
        lista.add("8kXcboyUgPg");
        lista.add("c6Z9t58BVOk");
        lista.add("8XScXKDK90Q");
        lista.add("d4CP3_3TpZY");
        lista.add("dcJWbMdVtDs");
        lista.add("IVZPAGMja6s");
        lista.add("aLVOtKESwjI");
        lista.add("zknxPYZXb6M");
        lista.add("GcjTtC1yBvM");
        lista.add("jjjdHZQ8cN0");
        lista.add("El0X6rcYwWA");
        lista.add("5kx4Y4KlKIs");
        lista.add("Fck22_dKfxk");
        lista.add("3HAONiaQ1Ag");
        lista.add("O6y6rL7lDxQ");
        lista.add("I_aCRDD3484");
        lista.add("HuY5Ei4ujwE");
        lista.add("r7TcyeNoWYU");
        lista.add("5_CpKA-0D78");
        lista.add("DNBtIr7HXbk");
        lista.add("XT_0dkxSGbg");
        lista.add("p3_kfYWJCfc");
        lista.add("oxkZWwt_KIk");
        lista.add("IeaMsf6Pgv4");
        lista.add("pKkMSe-VJT8");
        lista.add("txjCfkscEGM");
        lista.add("ue-oJKjM01k");
        lista.add("YbUhYlIU-yM");
        lista.add("RJSwkJ4Dj-U");
        lista.add("JPgSzrWMJ-U");
        lista.add("wy9Sia5urU8");
        lista.add("1CfkFGTSFnY");
        lista.add("UMlK5Z29Pyw");
        lista.add("yNv8DSjb0Yo");
        lista.add("W0dnXAB3IwQ");
        lista.add("AWvd0-dEcKc");
        lista.add("0rqzuctjtuQ");
        lista.add("yQwo9ossdIk");
        lista.add("BZgU8t4iRzg");
        lista.add("slsiC61xsTQ");
        lista.add("4lMnLyrWFzA");
        lista.add("u5ymR5rJgkU");
        lista.add("GsulyEk3CNY");
        lista.add("n1xMcidd_nQ");
        lista.add("UrtqEupygIA");
        lista.add("TC0_Y7rBHE0");
        return lista;
    }

    public List<String> mostrarVideosSusto(){
        List<String> lista = new ArrayList<>();
        lista.add("HA5ilJS57eU");
        return lista;
    }

}

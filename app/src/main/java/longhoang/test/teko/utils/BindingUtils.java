package longhoang.test.teko.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import longhoang.test.teko.R;
import longhoang.test.teko.data.model.api.Product;

public final class BindingUtils {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).placeholder(R.drawable.default_image).dontAnimate().into(imageView);
    }

    @BindingAdapter("imageProduct")
    public static void setImageProduct(ImageView imageView, Product product) {
        if (product.getImages() == null) {
            Context context = imageView.getContext();
            Glide.with(context)
                    .load("https://cdn.zeplin.io/5cff19421786a65d32d70edd/assets/13772DB0-4A99-4C74-A603-B84727E4B752.png")
                    .placeholder(R.drawable.default_image)
                    .into(imageView);
            return;
        }
        Context context = imageView.getContext();
        Glide.with(context)
                .load(product.getImages().size() > 0 ? product.getImages().get(0).getUrl() : "https://cdn.zeplin.io/5cff19421786a65d32d70edd/assets/13772DB0-4A99-4C74-A603-B84727E4B752.png")
                .placeholder(R.drawable.default_image)
                .into(imageView);
    }

    @BindingAdapter("colorSNS")
    public static void setColorSns(View view, int color) {
        view.setBackgroundResource(color);
    }

    @BindingAdapter("viewLogin")
    public static void setViewLogin(RelativeLayout relativeLayout, int custom) {
        relativeLayout.setBackgroundResource(custom);
    }

    @BindingAdapter("errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    @BindingAdapter("htmlText")
    public static void setErrorMessage(TextView view, String htmlText) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT));
        } else {
            view.setText(Html.fromHtml(htmlText));
        }
    }

    @BindingAdapter("backgroundResource")
    public static void setBackGroundRes(View view, int color) {
        view.setBackgroundResource(color);
    }

    @BindingAdapter("cardBackgroundRes")
    public static void setCardBackgroundRes(CardView cardView, boolean isActive) {
        if (isActive) {
            cardView.setCardBackgroundColor(Color.parseColor("#50B9F1"));
        } else {
            cardView.setCardBackgroundColor(Color.WHITE);
        }
    }

    @BindingAdapter("price")
    public static void setTotalPrice(TextView textView, String price) {
        long balance = Long.parseLong(price);
        if (balance == 0) {
            textView.setText(String
                    .format(textView.getContext().getString(R.string.vnd),
                            textView.getContext().getString(R.string.str_default_price_zero)));
        } else {
            DecimalFormatSymbols symbol = DecimalFormatSymbols.getInstance(Locale.getDefault());
            DecimalFormat formatter = new DecimalFormat("#,###,###", symbol);
            textView.setText(String
                    .format(textView.getContext().getString(R.string.vnd),
                            formatter.format(balance)));
        }
    }
}

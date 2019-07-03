package longhoang.test.teko.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;

import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import longhoang.test.teko.R;
import longhoang.test.teko.data.model.api.Product;

/**
 * Created by Cong Nguyen on 2/19/19.
 */
public final class BindingUtils {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    @BindingAdapter("imageProduct")
    public static void setImageProduct(ImageView imageView, Product product) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(product.getImages().size() > 0 ? product.getImages().get(0).getUrl() : "")
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
}

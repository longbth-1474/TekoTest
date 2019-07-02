package longhoang.test.teko.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.util.Patterns;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import longhoang.test.teko.R;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public class CommonUtils {
    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getTimestamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
    }

    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName)
        throws IOException {
        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return new String(buffer, "UTF-8");
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        pattern = AppConstants.PATTERN_PASSWORD;
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static BitmapImageViewTarget getRoundedImageTarget(@NonNull final Context context,
                                                              @NonNull
                                                              final AppCompatImageView imageView,
                                                              final float radius) {
        return new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(final Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCornerRadius(radius);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        };
    }

    public static String feedDatimeFormat(String time) {
        try {
            DateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault());
            Date date = dateFormat.parse(time);
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
            return formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}

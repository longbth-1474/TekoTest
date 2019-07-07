package longhoang.test.teko.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import longhoang.test.teko.R;

public class CommonUtils {
    private CommonUtils() {
        // This utility class is not publicly instantiable
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

    public static String convertPrice(long price) {
        if (price == 0) {
            return String.format("%s đ", "0");
        } else {
            DecimalFormatSymbols symbol = DecimalFormatSymbols.getInstance(Locale.getDefault());
            DecimalFormat formatter = new DecimalFormat("#,###,###", symbol);
            return String.format("%s đ", formatter.format(price));
        }
    }
}

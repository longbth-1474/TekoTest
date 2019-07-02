package longhoang.test.teko.utils;

import android.text.TextUtils;

public class IsValidateUtils {
    private IsValidateUtils() {
    }

    public static boolean isEmailValid(String email) {
        return (!TextUtils.isEmpty(email) &&
            android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim())
                .matches());
    }
}

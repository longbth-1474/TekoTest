package longhoang.test.teko.utils;

import java.util.regex.Pattern;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public class AppConstants {
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
    public static final String DB_NAME = "bAnk.db";
    public static final String REGEX_VALIDATE_PASSWORD = "^(?=.*[0-9])(?=.*[A-Z])(?=" +
        ".*[@#$%^&+=!])(?=\\S+$).{4,}$";
    public static final Pattern PATTERN_PASSWORD = Pattern.compile(REGEX_VALIDATE_PASSWORD);
    public static final String IS_FIRST_LOGGED = "is_first_logged";
    public static final String IS_FIRST_OPEN = "is_first_open";
    public static final String IS_LOGGED = "is_logged";
    public static final int KEY_DIALOG_FRAGMENT_DIS_LIKE = 1;
    public static final String FEED_LIKE_STATUS = "status";
    public static final String ACTION_LIKE= "optin";
    public static final String ACTION_DISLIKE= "optout";
    public static final String ACTION_UNREAD= "unread";

}

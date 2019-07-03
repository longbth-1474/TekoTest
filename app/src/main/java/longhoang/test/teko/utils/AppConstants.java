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

    public static final String CHANNEL = "channel";
    public static final String VISITOR_ID = "visitorId";
    public static final String QUERY = "q";
    public static final String TERMINAL = "terminal";
    public static final long TIMEOUT = 60;
    public static final String SKU = "sku";
}

package lt.cybergear.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Marius Kavoliūnas on 14.11.6.
 */
public class Metrics {

    /**
     * Converts dp dimension to equivalent px dimension
     * @param dp dimension to convert to px in dp
     * @return px value of given dp dimension.
     */
    public static int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                Resources.getSystem().getDisplayMetrics()
        );
    }

}

package lt.cybergear.utils;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalDigitsInputFilter implements InputFilter {

    Pattern mPattern;

    /**
     * Prepares InputFilter[] with this filter inside only
     * @param digitsBeforeZero amount of digits before dot
     * @param digitsAfterZero amount of digits after dot
     * @return prepared InputFilter[] with only this filter inside
     */
    public static InputFilter[] get(int digitsBeforeZero, int digitsAfterZero) {
        return new InputFilter[]{new DecimalDigitsInputFilter(digitsBeforeZero, digitsAfterZero)};
    }

    /**
     * Creates InputFilter, to filter right decimal numbers in EditText.
     * @param digitsBeforeZero amount of digits before dot
     * @param digitsAfterZero amount of digits after dot
     */
    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
        mPattern = Pattern.compile("[0-9]{1," + digitsBeforeZero + "}+(\\.[0-9]{0," + digitsAfterZero + "})?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String dst = dest.toString();
        String dstStart = dst.substring(0, dstart);
        String dstEnd = dst.substring(dend);
        String result = dstStart + source.subSequence(start, end) + dstEnd;
        Matcher matcher = mPattern.matcher(result);
        if (!matcher.matches())
            return "";
        return null;
    }

}
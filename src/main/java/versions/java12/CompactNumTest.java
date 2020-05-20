package versions.java12;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoy
 * @date 2020/05/15
 */

@Slf4j
public class CompactNumTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Test
    public void testCompactNumberFormat() {
        NumberFormat fmtShort = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

        NumberFormat fmtLong = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        log.info(fmtShort.format(312));
        log.info(fmtShort.format(3123));
        log.info(fmtShort.format(31234));

        log.info(fmtLong.format(312));
        log.info(fmtLong.format(3123));
        log.info(fmtLong.format(31234));
    }

    @Test
    public void useCustom() {
        String[] compactPatterns =
            {"", "", "", "0千", "0万", "00万", "0百万", "0千万", "0亿", "00亿", "0百亿", "0千亿", "0兆", "00兆", "000兆"};

        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(Locale.CHINA);

        CompactNumberFormat format = new CompactNumberFormat(decimalFormat.toPattern(),
            decimalFormat.getDecimalFormatSymbols(), compactPatterns);

        log.info(format.format(312340000));
    }

    @Test
    public void testParse() throws ParseException {
        NumberFormat fmtLong = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        log.info(String.valueOf(fmtLong.parse("3 thousand")));
    }

}

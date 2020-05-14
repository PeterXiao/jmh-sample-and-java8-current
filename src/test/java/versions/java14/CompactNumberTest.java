package versions.java14;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
@Slf4j
public class CompactNumberTest {
    public static NumberFormat getCompactNumberInstance(Locale locale, NumberFormat.Style formatStyle) {
        return null;
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

}

package versions.java12;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
import java.text.NumberFormat;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompactNumberFormatExample {
    public static void main(String[] args) {
        NumberFormat followers =
            NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        followers.setMaximumFractionDigits(1);
        System.out.println(followers.format(5412) + " followers");
    }

}
 package versions.java14;

import org.junit.Test;

import static java.util.Calendar.*;


/**
 * @author xiaoy
 * @date 2020/05/10
 */
public class SwitchTest {

    @Test
    public void useOldSwitch(){
        switch (MONDAY) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
    }

    @Test
    public void useNewSwitch(){
        switch (MONDAY) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY                -> System.out.println(7);
            case THURSDAY, SATURDAY     -> System.out.println(8);
            case WEDNESDAY              -> System.out.println(9);
        }
    }

    @Test
    public void oldSwitchWithReturnValue(){
        int numLetters;
        switch (MONDAY) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("这天没发见人！");
        }
    }

    @Test
    public void newSwitchWithReturnValue(){
        int numLetters = switch (MONDAY) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
            default -> throw new IllegalStateException("这天没发见人!");
        };
    }

    @Test
    public void withYield(){
        int result = switch (MONDAY) {
            case MONDAY: {
                yield 1;
            }
            case TUESDAY: {
                yield 2;
            }
            default: {
                System.out.println("不是MONDAY，也不是TUESDAY！");
                yield 0;
            }
        };
    }

    public static void main(String[] args) {
//        String s1 = "古时的风筝";
//        System.out.println(s1 == "古时的风筝");
//        System.out.println(s1.equals("古时的风筝") );
//        String s5 = "古时的风筝";
//        String a = "古时的";
//        String s2 = new String(a + "风筝");
//        String s3 = new String(a + "风筝");
//        System.out.println(s5==s2); // false
//        System.out.println(s2==s3);  // false 
        
        String s1 = "古时的风筝";
        String s2 = "古时的风筝";
        String a = "古时的";
      
        String s3 = new String(a + "风筝");
        String s4 = new String(a + "风筝");
        System.out.println(s1 == s2); // 【1】 true
        System.out.println(s2 == s3); // 【2】 false
        System.out.println(s3 == s4); // 【3】 false
        s3.intern();
        System.out.println(s2 == s3); // 【4】 false
        s3 = s3.intern();
        System.out.println(s2 == s3); // 【5】 true
        s4 = s4.intern();
        System.out.println(s3 == s4); // 【6】 true
        
        String s11 = "Java";
        String s22 = "Java";
        System.out.println(s11 == s22);
     }
}

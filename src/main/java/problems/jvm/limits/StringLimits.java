package problems.jvm.limits;

/**
 * @author xiaoy
 * @date 2020/06/17
 */
public class StringLimits {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "";
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
            s += "i";
        }

    }

}

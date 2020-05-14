package versions.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoy
 * @date 2020/05/12
 */
public class StringEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "胡";
        byte[] buff = str.getBytes("UTF-8");
        int i = buff.length;
        System.out.println(i); // 3

        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = list1.subList(0, list1.size());
        list2.add("c");
        // 修改list2，而影响到list1，输出结果为 a b c
        for (String str1 : list1) {
            System.out.println(str1);
        }
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }
}

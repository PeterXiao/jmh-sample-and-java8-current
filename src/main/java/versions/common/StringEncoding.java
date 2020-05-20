package versions.common;

import java.io.ObjectInputFilter;
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

    /*    LocalDateTime readDateTime(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            ois.setObjectInputFilter(FilterClass::dateTimeFilter);
            return (LocalDateTime) ois.readObject();
        } catch (ClassNotFoundException ex) {
            IOException ioe = new StreamCorruptedException("class missing");
            ioe.initCause(ex);
            throw ioe;
        }
    }*/

    public boolean equals(Object obj) {
        return (this == obj);
    }
}

class FilterNumber implements ObjectInputFilter {
    public Status checkInput(FilterInfo filterInfo) {
        Class<?> clazz = filterInfo.serialClass();
        if (clazz != null) {
            return (Number.class.isAssignableFrom(clazz)) ? Status.ALLOWED : Status.REJECTED;
        }
        return Status.UNDECIDED;
    }

    static ObjectInputFilter.Status baseFilter(ObjectInputFilter.FilterInfo info) {
        Class<?> serialClass = info.serialClass();
        if (serialClass != null) {
            return serialClass.getModule().getName().equals("java.base") ? ObjectInputFilter.Status.ALLOWED
                : ObjectInputFilter.Status.REJECTED;
        }
        return ObjectInputFilter.Status.UNDECIDED;
    }
}

package com.extendbase;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
public class testcon {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*        List arrayList = new ArrayList();
        arrayList.add("cxuan");
        arrayList.add(100);
        
        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String)arrayList.get(i);
            System.out.println("test === ");
        }
        
        *java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        
        */
        // 这段代码在编译期间就会报错，编译器会在编译阶段就能够帮我们发现类似这样的问题。
        /*        List<String> arrayList = new ArrayList<String>();
        
        arrayList.add(100);
        
        arrayList.add("cxuan");
        arrayList.add(100, null);
        
        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String)arrayList.get(i);
            System.out.printf("test === ", item);
        }
        */

    }

}

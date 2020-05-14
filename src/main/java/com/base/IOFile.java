package com.base;

import java.io.File;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
public class IOFile {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:\\file.txt");
        try {
            file.createNewFile(); // 创建一个文件

            // File类的两个常量
            // 路径分隔符(与系统有关的）<windows里面是 ; linux里面是 ： >
            System.out.println(File.pathSeparator); // ;
            // 与系统有关的路径名称分隔符<windows里面是 \ linux里面是/ >
            System.out.println(File.separator); // \

            // 删除文件
            /*
            File file = new File(fileName);
            if(f.exists()){
              f.delete();
            }else{
              System.out.println("文件不存在");
            }   
            */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FileDemodir {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "filepackage";
        File file = new File(fileName);
        file.mkdir();

        // 列出所有文件
        /*
        String[] str = file.list();
        for (int i = 0; i < str.length; i++) {
        System.out.println(str[i]);
        }
        */

        // 使用 file.listFiles(); 列出所有文件，包括隐藏文件

        // 使用 file.isDirectory() 判断指定路径是否是目录
    }
}

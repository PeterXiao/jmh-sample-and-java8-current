package problems.jvm.oom;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟PermGen OOM
 * 
 * @author benhail
 */
public class OOMTest {
    public static void main(String[] args) {
        try {
            // 准备url 使用相对路径
            URL url = new File("target\\classes\\problems\\jvm\\oom").toURI().toURL();
            System.out.println(url);
            URL[] urls = {url};
            // 获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            // 用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            int i = 1;
            while (true) {
                // 加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("problems.jvm.oom.ClassA");
                // 显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: " + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
                i++;
                System.out.println("i++ =" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

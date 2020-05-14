package versions.bugs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author xiaoy
 * @date 2020/05/12
 */
public class SubListTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>() {
            {
                add("Hollis");
                add("hollischuang");
                add("H");
            }
        };

        List subList = names.subList(0, 1);
        // System.out.println(subList);

        ArrayList subList1 = (ArrayList)names.subList(0, 1);
        System.out.println(subList1);

        // 如何创建新的List
        // 如果需要对subList作出修改，又不想动原list。那么可以创建subList的一个拷贝：
        // subList = Lists.newArrayList(subList);
        // list.stream().skip(strart).limit(end).collect(Collectors.toList());
    }

    @Test // 1、非结构性改变SubList
    public void sublistchange() {
        List<String> sourceList = new ArrayList<String>() {
            {
                add("H");
                add("O");
                add("L");
                add("L");
                add("I");
                add("S");
            }
        };

        List subList = sourceList.subList(2, 5);

        System.out.println("sourceList ： " + sourceList);
        System.out.println("sourceList.subList(2, 5) 得到List ：");
        System.out.println("subList ： " + subList);

        subList.set(1, "666");

        System.out.println("subList.set(3,666) 得到List ：");
        System.out.println("subList ： " + subList);
        System.out.println("sourceList ： " + sourceList);
    }

    @Test // 1、非结构性改变SubList
    public void sublist2change() {
        List<String> sourceList = new ArrayList<String>() {
            {
                add("H");
                add("O");
                add("L");
                add("L");
                add("I");
                add("S");
            }
        };

        List subList = sourceList.subList(2, 5);

        System.out.println("sourceList ： " + sourceList);
        System.out.println("sourceList.subList(2, 5) 得到List ：");
        System.out.println("subList ： " + subList);

        subList.add("666");

        System.out.println("subList.add(666) 得到List ：");
        System.out.println("subList ： " + subList);
        System.out.println("sourceList ： " + sourceList);

    }

    @Test // 1、结构性改变原List
    public void sublist3change() {
        List<String> sourceList = new ArrayList<String>() {
            {
                add("H");
                add("O");
                add("L");
                add("L");
                add("I");
                add("S");
            }
        };

        List subList = sourceList.subList(2, 5);

        System.out.println("sourceList ： " + sourceList);
        System.out.println("sourceList.subList(2, 5) 得到List ：");
        System.out.println("subList ： " + subList);

        sourceList.add("666");

        System.out.println("sourceList.add(666) 得到List ：");
        System.out.println("sourceList ： " + sourceList);
        System.out.println("subList ： " + subList);
    }
}

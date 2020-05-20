package versions.java11;

import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaoy
 * @date 2020/05/15
 * 
 *       正如关于不可变性中所讨论的，不可变集合可以包含可变对象，如果是，则集合既不是不可变的也不是线程安全的。 如果一个对象的状态在构造后不能改变，则该对象被认为是不可变的。
 *       在创建集合的不可变实例后，只要对其存在引用，它就会保留相同的数据。
 */
public class ImmuCollection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 在jdk 1.8:

        List<String> stringList = Arrays.asList("a", "b", "c");
        stringList = Collections.unmodifiableList(stringList);

        // 同样的效果在jdk 1.9可以如下实现:

        List stringList11 = List.of("a", "b", "c");

        Set<String> stringSet = Set.of("a", "b", "c");

        Map stringMap = Map.of("a", 1, "b", 2, "c", 3);

        Map<Integer, String> friendMap =
            Map.ofEntries(entry(1, "Tom"), entry(2, "Dick"), entry(3, "Harry"), entry(99, "Mathilde"));

        Set<String> set = new HashSet<>(3); // 3 buckets
        set.add("silly");
        set.add("string");
        set = Collections.unmodifiableSet(set);

        Set<String> set11 = Set.of("silly", "string");

    }

    /* List<Item> list = new ArrayList<>();
    list.addAll(getItemsFromSomewhere());
    list.addAll(getItemsFromElsewhere());
    list.addAll(getItemsFromYetAnotherPlace());
    List<Item> snapshot = List.copyOf(list);
    
    Collectors.toUnmodifiableList()
    Collectors.toUnmodifiableSet()
    Collectors.toUnmodifiableMap(keyMapper, valueMapper)     
    Collectors.toUnmodifiableMap(keyMapper, valueMapper, mergeFunction)
    
     Set<Item> immutableSet =
      sourceCollection.stream()
                      .map(...) 
                      .collect(Collectors.toUnmodifiableSet());
    
    
    */

}

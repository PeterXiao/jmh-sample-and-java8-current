package algorithms.lru;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheT<K, V> extends LinkedHashMap<K, V> {

    // 最大容量
    private final int maximumSize;

    public LRUCacheT(final int maximumSize) {
        // true代表按访问顺序排序，false代表按插入顺序
        super(maximumSize, 0.75f, true);
        this.maximumSize = maximumSize;
    }

    /**
     * 当节点数大于最大容量时，就删除最旧的元素
     */
    @Override
    protected boolean removeEldestEntry(final Map.Entry eldest) {
        return size() > this.maximumSize;
    }
}

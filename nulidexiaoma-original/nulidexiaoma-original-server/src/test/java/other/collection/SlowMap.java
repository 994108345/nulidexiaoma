package other.collection;/**
 * Created by wenzailong on 2018/7/23.
 */

import com.mchange.v2.collection.MapEntry;

import java.util.*;

/**
 * @author wenzailong
 * @create 2018-07-23 17:38
 **/
public class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<>();
    public V put(K key,V value){
        V oldValue = get(key);
        /*key存在就替换value，不存在就新增key和value*/
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }
    public V get(Object key){
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext()){
            set.add(new MapEntry(ki.next(),vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m = new SlowMap<String,String>();
        m.putAll(Countries.capitails(12));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());

    }
}

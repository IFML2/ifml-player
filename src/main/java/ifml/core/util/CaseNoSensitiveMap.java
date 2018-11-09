package ifml.core.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CaseNoSensitiveMap<T> implements Map<String, T> {

    private Map<String, T> map = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(_key(key));
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public T get(Object key) {
        return map.get(_key(key));
    }

    @Override
    public T put(String key, T value) {
        return map.put(_key(key), value);
    }

    @Override
    public T remove(Object key) {
        return map.remove(_key(key));
    }

    @Override
    public void putAll(Map<? extends String, ? extends T> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<T> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, T>> entrySet() {
        return map.entrySet();
    }

    private String _key(Object key) {
        return ((String) key).toLowerCase();
    }

}

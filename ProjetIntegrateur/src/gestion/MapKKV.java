package gestion;

import java.util.HashMap;

public class MapKKV<X, Y, V> {

    HashMap<Key, V> map = new HashMap<>();

    public V put(X x, Y y, V v) {
        map.put(new Key(x,y), v);
        return v;
    }

    public V get(X x, Y y) {
        return map.get(new Key(x,y));
    }
    
    public void clear(){
        map.clear();
    }
    
    public V remove(X x, Y y){
        return map.remove(new Key(x,y));
    }
    
   

    private class Key {

        private final X x;
        private final Y y;

        public Key(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o.getClass() != Key.class)) {
                return false;
            }
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            int result = x.hashCode();
            result = 31 * result + y.hashCode();
            return result;
        }
    }
}
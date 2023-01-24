package HashMap;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashMap {
    private class Entry {
        private int Key;
        private String Value;
        Entry(int k, String v){
            this.Key=k;
            this.Value = v;
        }
    }
    LinkedList<Entry>[] map ;
    HashMap(int n){
        map = new LinkedList[n];
    }
    public void put(int k, String v){
        int index = Hash(k);
        if(map[index]==null){
            map[index] = new LinkedList<>();
        }
        LinkedList<Entry> bucket = map[index];
        for(Entry e: bucket){
            if(e.Key == k){
                e.Value = v;
                return;
            }
        }
        bucket.add(new Entry(k, v));
    }
    private int Hash(int key){
        return key % map.length;
    }
    public String get(int k){
        int index = Hash(k);
        LinkedList<Entry> bucket = map[index];
        if(bucket != null){
            for(Entry e:bucket){
                if(e.Key == k)return e.Value;
            }
        }
        return null;
    }

    public void remove(int k){
        int index = Hash(k);
        LinkedList<Entry> bucket = map[index];
        if(bucket == null) throw new NoSuchElementException();
        for(Entry e:bucket){
            if(e.Key == k){
                bucket.remove(e);
                return;
            }
        }
        throw new NoSuchElementException();
    }
}

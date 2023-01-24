package HashMap;

public class HashMapImpl {
    public static void main(String args[]){
        HashMap map = new HashMap(5);
        map.put(1, "Dipak");
        map.put(2,"Harsh");
        map.put(11, "Sweta");
        map.put(15, "Ravi");
        System.out.println(map.get(1));
        System.out.println(map.get(0));
        System.out.println(map.get(11));
        map.put(10,"Rahul");
        System.out.println(map.get(1));
        map.remove(10);
        System.out.println(map.get(10));
    }
}

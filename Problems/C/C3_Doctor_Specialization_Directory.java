package C;

public class C3_Doctor_Specialization_Directory {
    private String[] keys;
    private String[] values;
    private int capacity;

    public C3_Doctor_Specialization_Directory(int capacity) {
        this.capacity = capacity;
        keys = new String[capacity];
        values = new String[capacity];
    }

    private int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = hash * 31 + key.charAt(i);
        }

        return Math.abs(hash) % capacity;
    }

    public void put(String key, String value) {

        int index = hash(key);

        for (int i = 0; i < capacity; i++) {

            int position = (index + i) % capacity;

            if (keys[position] == null) {
                keys[position] = key;
                values[position] = value;
                return;
            }

            if (keys[position].equals(key)) {
                values[position] = value;
                return;
            }
        }
    }

    public String get(String key) {

        int index = hash(key);

        for (int i = 0; i < capacity; i++) {

            int position = (index + i) % capacity;

            if (keys[position] == null) {
                return null;
            }

            if (keys[position].equals(key)) {
                return values[position];
            }
        }

        return null;
    }

    public static void main(String[] args) {

        C3_Doctor_Specialization_Directory dictionary = new C3_Doctor_Specialization_Directory(10);

        dictionary.put("D101", "Cardiology");
        dictionary.put("D102", "Neurology");


        System.out.println(dictionary.get("D101"));
    }
}

package Ex3;

import redis.clients.jedis.Jedis;

import java.util.*;

public class forum {

    public static String USERS = "users"; // Key set for users' name

    public static void main(String[] args) {
       
        Jedis jedis = new Jedis();

        // a)
        System.out.println(jedis.ping());
        //System.out.println(jedis.info());
        System.out.println(jedis.hset("names" , "n1", "Nuno")); //returns 1 if its a new field and 0 if the field already exists
        System.out.println(jedis.hset("names" , "n2", "Diogo"));
        System.out.println(jedis.hset("names" , "n3", "Vasco"));
        System.out.println(jedis.hget("names", "n1"));
        System.out.println("O " + jedis.hget("names", "n1") + " está a dever dinheiro ao " + jedis.hget("names", "n2"));

        

        //HMSET names n1 "Paulo" n2 "Tiago" n3 "Raquel"
        //HGET names n1
        //HDEL names n1
        //HGET names n1

        // b)
        String[] users_set = { "Ana", "Pedro", "Maria", "Luis" }; // isto é um set
        jedis.del(USERS);    // remove if exists to avoid wrong type
             // SET, exemplo professor
        for (String user : users_set)
            jedis.sadd(USERS, user);
        System.out.println("Printando resultados usando Set:");
        jedis.smembers(USERS).forEach(System.out::println);
        jedis.close();
              // Lista
        List<String> list = new ArrayList<String>(Arrays.asList(users_set));
        users_list list_users = new users_list();
        for (String user: list) list_users.Add_User_to_list(user);

        System.out.println("Printando resultados usando Lista:");
        System.out.println("User List:");
        list_users.getUserList().forEach(System.out::println);
        System.out.println("Keys:");
        list_users.ListKeys().forEach(System.out::println);
              //HASH
        Map<String, String> map = new HashMap<>();
        users_Hash hash_users = new users_Hash();
        int x = 1;
        for (String user: users_set){
            map.put("user" + x, user);
            x++;
        }

        hash_users.Add_User_to_hash(map);

        Map<String, String> new_map = hash_users.getUserHashMap();
        System.out.println("Printando resultados usando HashMap:");
        System.out.println("User HashMap:");
        for (String key: new_map.keySet()) {
            System.out.println(new_map.get(key));
        }
        System.out.println("Keys:");
        hash_users.ListKeys().forEach(System.out::println);


    }

}

// classes feitas com base no ficheiro SimplePost.java dado pelo professor no e-learning
class users_Hash {
    private final Jedis jedis;
    public static String USERS = "users3";

    public users_Hash() {
        this.jedis = new Jedis();
    }

    public void Add_User_to_hash(Map<String, String> Users_map) { jedis.hmset(USERS, Users_map); }

    public Map<String, String> getUserHashMap() { return jedis.hgetAll(USERS); }

    public Set<String> ListKeys() { return jedis.keys("*"); }
}

class users_list {
    private final Jedis jedis;
    public static String USERS = "users2";

    public users_list() {
        this.jedis = new Jedis(); //no url, using localhost for testing
    }

    public void Add_User_to_list(String user) { jedis.lpush(USERS, user); }

    public List<String> getUserList() { return jedis.lrange(USERS, 0, -1); }

    public Set<String> ListKeys() { return jedis.keys("*"); }
}


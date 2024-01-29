

package redis;
import java.io.*;
import java.util.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
public class App 
{
    static PostSet boardSet = new PostSet();
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose the 'alinea': ");
        String op = scanner.nextLine();

        if (op.length() == 1) {
            char inputChar = Character.toLowerCase(op.charAt(0));
            if (inputChar == 'a') {
                alineaA();
            } else if (inputChar == 'b') {
                alineaB();
            } else {
                System.out.println("Choose A ou B");
                main(args);
            }
        } else {
            System.out.println("Insert a character (A ou B)");
            main(args);
        }

        scanner.close();
    }
    
    public static void alineaA() {
        PostSet boardSet = new PostSet();
        
        try (Scanner op = new Scanner(new File("names.txt"))) {

            while (op.hasNext()) {
                String name = op.next();
                boardSet.saveUser(name);
            }

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Search for ('Enter for quit'): ");
                String search_name = sc.nextLine();
                if (search_name.length() == 0) {
                    break;
                }

                Set<String> answers = boardSet.getUser(search_name);
                System.out.println(search_name);
                for (String answer : answers) {
                    System.out.println(answer);
                }
                System.out.println();

            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(0);
        }

    }
    
    public static void alineaB() {
        PostCsv postCsv = new PostCsv();
        try (Scanner input2 = new Scanner(new File("nomes-pt-2021.csv"))) {

            while (input2.hasNext()) {
                String[] row = input2.next().split(";");
                postCsv.saveUser(row[0], Integer.parseInt(row[1]));
            }

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Search for ('Enter for quit'): ");
                String search_name = sc.nextLine();
                if (search_name.length() == 0) {
                    break;
                }
        
                Set<String> result = postCsv.getUserByPopularity(search_name);
                for (String name : result) {
                    System.out.println(name);
                }
            }
            sc.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(0);
        }
    }

}

class PostSet {
    private Jedis jedis;
    public static String USERS = "names";

    public PostSet() {
        this.jedis = new Jedis("localhost", 6379);
        jedis.flushAll();
    }

    public void saveUser(String username) {
        jedis.zadd(USERS, 0, username); 
    }

    public Set<String> getUser(String search) {
        List<String> resultList = jedis.zrangeByLex(USERS, "[" + search + "*", "[" + search + (char)0xFF); //'*' indica que você deseja incluir todos os valores que começam com a string search
        Set<String> resultSet = new HashSet<>(resultList);
        return resultSet;
    }


    public Set<String> getAllKeys() {
        return jedis.keys("*");
    }
}


class PostCsv {
    private Jedis jedis;
    public static String USERS = "names";

    public PostCsv() {
        this.jedis = new Jedis("localhost", 6379);
        jedis.flushAll();
    }

    public void saveUser(String username, int score) {
        jedis.zadd(USERS, score,username);
    }

    // Consulta de autocomplete com ordenação por popularidade
    public Set<String> getUserByPopularity(String search) {
        List<String> resultList = jedis.zrevrangeByLex(USERS, "[" + search + "*", "[" + search + (char)0xFF);
        Set<String> resultSet = new LinkedHashSet<>(resultList);
        return resultSet;
    }

    public Set<String> getAllKeys() {
        return jedis.keys("*");
    }
}
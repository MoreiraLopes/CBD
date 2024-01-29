package cbd;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

public class App {
    static Session session;

    public static void main(String[] args) {
        try {
            Cluster cluster = Cluster.builder().addContactPoint("127.19.0.2").build();
            session = cluster.connect("cbd_107572_ex2");
            
            System.out.println(">> Connected to Cassandra (127.19.0.2:9042)");

            alineaA();
            alineaB();

        } catch (Exception e) {
            System.err.println("Couldn't connect to Cassandra at 127.19.0.2:9042");
            System.exit(1);
        }
    }

    private static void alineaA() {
        // data insertion
        try {
            session.execute("INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (0, {'pewdiepie', 'cryaotic'});");
            session.execute("INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (0, {'dashiegames', 'cryaotic'});");
            session.execute("INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (1, 3);");

            System.out.println("Inserts done correctly.\n");
        } catch (Exception e) {
            System.err.println("Inserts failed. Exiting.\n" + e.getMessage());
            System.exit(1);
        }

        // data updating
        try {
            System.out.println("Update name to 'goncas' where username is 'gametheory'. ");
            session.execute("UPDATE users SET name='goncas' WHERE username='gametheory';");
            for (Row r : session.execute("SELECT * FROM users WHERE username='gametheory';")) {
                System.out.println(r.toString());
            }

            System.out.println("Update name to 'Ocult History' where video id is 0.");
            session.execute("UPDATE videos SET name='Ocult History' WHERE id=0;");
            for (Row r : session.execute("SELECT * FROM videos WHERE id=0;")) {
                System.out.println(r.toString());
            }

            System.out.println("Updates done.\n");
        } catch (Exception e) {
            System.err.println("Updates failed. Exiting.\n" + e.getMessage());
            System.exit(1);
        }


        // data searching
        try {

            System.out.println("Get all users.");
            for (Row r : session.execute("SELECT * FROM users;")) {
                System.out.println(r.toString());
            }

            System.out.println("Lista das tags de determinado video.");
            for (Row r : session.execute("select id, tags from videos where id=5;")) {
                System.out.println(r.toString());
            }

            System.out.println("Searches done.\n");
        } catch (Exception e) {
            System.err.println("Search failed. Exiting.\n" + e.getMessage());
            System.exit(1);
        }
    }

    private static void alineaB() {
        try {
            System.out.println("1. Os ultimos 3 comentarios introduzidos para um video");
            for (Row r : session.execute("select * from comments_by_video where id_video=10 limit 3;")) {
                System.out.println(r.toString());
            }

            System.out.println("2. Lista das tags de determinado video;");
            for (Row r : session.execute("select id, tags from videos where id=5;")) {
                System.out.println(r.toString());
            }

            System.out.println("4. Os ultimos 5 eventos de determinado video realizados por um utilizador");
            for (Row r : session.execute("select * from events where username='pewdiepie' and id_video=2 limit 5;")) {
                System.out.println(r.toString());
            }

            System.out.println("7. Todos os seguidores (followers) de determinado video");
            for (Row r : session.execute("select users from followers where id_video=5;")) {
                System.out.println(r.toString());
            }

            
        } catch (Exception e) {
            System.err.println("Queries failed. Exiting.\n" + e.getMessage());
            System.exit(1);
        }
    }
}
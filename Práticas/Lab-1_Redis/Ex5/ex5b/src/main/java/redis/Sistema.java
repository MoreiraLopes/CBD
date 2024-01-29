package redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;





public class Sistema
{
    private final Jedis jedis;
    private final int limit;
    private final int timeslot;

    public Sistema(Jedis jedis,int limit, int timeslot) {
        this.limit = limit;
        this.timeslot = timeslot;
        this.jedis=jedis;
    }



    public void Request(String username, String item, int quantity) {
        String requestDataKey = "Requests:" + username;
        String expirationKey = "Requests:" + username;
        String quantityNow = String.valueOf(quantity);
        

        boolean itemExists = jedis.hexists(requestDataKey, item);
        long timeLeft = jedis.ttl(expirationKey);
    
        if (!itemExists || timeLeft < 0) {

            Pipeline pipeline = jedis.pipelined();
            

            jedis.hdel(requestDataKey, item);
            jedis.hset(requestDataKey, item, quantityNow);
            
            jedis.expire(expirationKey, timeslot);
            
            pipeline.sync();
            
            System.out.println(username + " requested " + item + ". Requested Quantity: " + quantityNow + ". Request accepted!");
        } else {

            
        }
    }
    




    public static void main( String[] args ) 
    {
        int limit=30;
        int timeslot=60*60;
        Jedis jedis = new Jedis("localhost",6379);
        jedis.flushAll();

        Sistema sistema = new Sistema(jedis,limit,timeslot);
        int n=0;
        
        while(n<30){
            sistema.Request("Gonçalo", "Laranjas",1);
            n++;
        }
        
        sistema.Request("Gonçalo", "Morangos",2);
        sistema.Request("Gonçalo", "Morangos",3);
        sistema.Request("Gonçalo", "Laranjas",1);
        sistema.Request("Gonçalo", "Laranjas",1);
        sistema.Request("Gonçalo", "Espinafres",30);
        sistema.Request("Gonçalo", "Espinafres",1);

        sistema.Request("Gonçalo", "Bananas", 15);
        jedis.close();
    }


}

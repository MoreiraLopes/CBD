package redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.concurrent.TimeUnit;


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



    public void Request(String username, String pedido) {
        String key = "Requests:" + username;
        long timeleft = jedis.ttl(key);
        boolean keyExists = jedis.exists(key);
    
        if (!keyExists && timeleft < 0) {
            // O usuário não fez nenhum pedido ou o tempo expirou
            jedis.del(key);
            jedis.rpush(key, pedido);
            jedis.expire(key, timeslot);
            System.out.println(username + " Requests: " + pedido + ". Request accepted!!");
        } else {
            long quantidadeDePedidos = jedis.llen(key);
    
            if (quantidadeDePedidos < limit && timeleft > 0) {
                // O usuário fez menos do que o limite de pedidos dentro do intervalo de tempo
                jedis.rpush(key, pedido);
                System.out.println(username + " Requests: " + pedido + ". Request accepted!!");
            } else {
                System.out.println(username + " Requests: " + pedido + ". Request not accepted...");
            }
        }
    }
    



    public static void main( String[] args ) 
    {
        int limit=30;
        int timeslot=60*60;
        Jedis jedis = new Jedis("localhost",6379);
        jedis.flushAll();

        Sistema sistema = new Sistema(jedis,limit,timeslot);
        int n=1;

        while(n<35){
            sistema.Request("Paulo", "Arroz");
            n++;
        }
        sistema.Request("Paulo","Maça");
        jedis.close();
    }


}
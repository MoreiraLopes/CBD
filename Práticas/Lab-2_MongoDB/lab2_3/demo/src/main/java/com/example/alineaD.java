package com.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.Projections;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Aggregates.group;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

class SistemaD{

        private MongoCollection<Document> collection;

    public SistemaD(){
        try {
            MongoClient mongoCliente = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoCliente.getDatabase("cbd");
            collection = database.getCollection("restaurants");
        } catch (MongoException e) {
            e.printStackTrace();
            System.exit(1);
            collection=null;
        }

    }


    public long countLocalidades() {
        long count = collection.distinct("localidade", String.class).into(new ArrayList<>()).size();
        return count;
    }





    public Map<String,Integer> countRestaurantsByLocalidade(){
        Map<String,Integer> restbylocalidade = new HashMap<>();

        AggregateIterable<Document> localidades = collection.aggregate(Arrays.asList(group("$localidade", Accumulators.sum("num",1))));


        for (Document l: localidades){
            Object idValue = l.get("_id");
            String localidade = (idValue != null) ? idValue.toString() : "Desconhecido";
            restbylocalidade.put(localidade, l.getInteger("num"));

        }



        return restbylocalidade;  
    }

    public List<String> getRestWithNameCloserto(String name){
        List<String> listarests= new ArrayList<String>();
            
        FindIterable<Document> rests = collection.find(Filters.regex("nome", name));

        for(Document r :rests){
            listarests.add(r.getString("nome"));
        }

        return listarests;
    }

}





public class alineaD {


    public static void main(String[] args) {
        SistemaD sistema = new SistemaD();
        System.out.println();
        

        


        try(PrintWriter txt = new PrintWriter(new File("CBD_L203_107572.txt"))){
            txt.println("Numero de localidades distintas: "+ sistema.countLocalidades());
            txt.println();

            txt.println("Numero de restaurantes por localidade: ");
            Map<String,Integer> restbylocalidade = sistema.countRestaurantsByLocalidade();
            for(String l: restbylocalidade.keySet()){
                txt.println("-> "+ l + " - " + restbylocalidade.get(l));
            }
            txt.println();

            txt.println("Nome de restaurantes contendo 'Park' no nome");
            List<String> listarests = sistema.getRestWithNameCloserto("Park");
            for(String rest:listarests){
                txt.println("-> "+ rest);
            }
            txt.println();


            System.out.println("The file was created successfully!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
        

}
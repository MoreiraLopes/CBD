package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;


public class alineaC {

    private MongoCollection<Document> collection;

    public alineaC() {
        try {
            MongoClient mongoCliente = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoCliente.getDatabase("cbd");
            collection = database.getCollection("restaurants");
        } catch (MongoException e) {
            e.printStackTrace();
            System.exit(1);
            collection = null;
        }
    }

    public void numRestaurantsInBronx(){
        System.out.println("4. Indique o total de restaurantes localizados no Bronx.\n");

        try {
            
            Bson filtro = Filters.eq("localidade", "Bronx");

           
            long count = collection.countDocuments(filtro);

            System.out.println("Número de documentos com localidade 'Bronx': " + count);
        } catch (Exception e) {
            System.err.println("Erro ao executar a consulta: " + e);
        }

    }

    public void latitudeLowerThan() {
        System.out.println("8. Indique os restaurantes com latitude inferior a -95.7.");

        double latitudeThreshold = -95.7;
        FindIterable<Document> docs = collection.find(Filters.lt("address.coord.0", latitudeThreshold));

        for (Document doc : docs) {
            System.out.println(doc.toJson());
        }
    }

    public void restaurantsWithNameStartingWithWil() {
        System.out.println("10. Liste o restaurant_id, o nome, a localidade e gastronomia dos restaurantes cujo nome começa por \"Wil\".");

        String prefix = "Wil";
        FindIterable<Document> docs = collection.find(Filters.regex("nome", "^" + prefix));

        for (Document doc : docs) {
            String restaurantId = doc.getString("restaurant_id");
            String nome = doc.getString("nome");
            String localidade = doc.getString("localidade");
            String gastronomia = doc.getString("gastronomia");

            System.out.println("restaurant_id: " + restaurantId);
            System.out.println("nome: " + nome);
            System.out.println("localidade: " + localidade);
            System.out.println("gastronomia: " + gastronomia);
            System.out.println();
        }
    }

    public void restaurantsInBronxWithAmericanOrChineseCuisine() {
        System.out.println("11. Liste o nome, a localidade e a gastronomia dos restaurantes que pertencem ao Bronx e cuja gastronomia é do tipo \"American\" ou \"Chinese\".");

        String borough = "Bronx";
        FindIterable<Document> docs = collection.find(Filters.and(
                Filters.eq("localidade", borough),
                Filters.in("gastronomia", Arrays.asList("American", "Chinese"))
        )).projection(Projections.include("nome", "localidade", "gastronomia"));

        for (Document doc : docs) {
            String nome = doc.getString("nome");
            String localidade = doc.getString("localidade");
            String gastronomia = doc.getString("gastronomia");

            System.out.println("Nome: " + nome);
            System.out.println("Localidade: " + localidade);
            System.out.println("Gastronomia: " + gastronomia);
            System.out.println();
        }
    }

    public void restaurantsInBoroughs() {
        System.out.println("12. Liste o restaurant_id, o nome, a localidade e a gastronomia dos restaurantes localizados em \"Staten Island\", \"Queens\", ou \"Brooklyn\".");

        List<String> boroughs = Arrays.asList("Staten Island", "Queens", "Brooklyn");

        FindIterable<Document> docs = collection.find(Filters.in("localidade", boroughs))
            .projection(Projections.include("restaurant_id", "nome", "localidade", "gastronomia"));

        for (Document doc : docs) {
            String restaurantId = doc.getString("restaurant_id");
            String nome = doc.getString("nome");
            String localidade = doc.getString("localidade");
            String gastronomia = doc.getString("gastronomia");

            System.out.println("restaurant_id: " + restaurantId);
            System.out.println("nome: " + nome);
            System.out.println("localidade: " + localidade);
            System.out.println("gastronomia: " + gastronomia);
            System.out.println();
        }
    }

    

    

    public static void main(String[] args) {
        alineaC sistema = new alineaC();
        sistema.numRestaurantsInBronx(); //pergunta4
        System.out.println();
        sistema.latitudeLowerThan(); //pergunta8
        System.out.println();
        sistema.restaurantsWithNameStartingWithWil(); //pergunta10
        System.out.println();
        sistema.restaurantsInBronxWithAmericanOrChineseCuisine(); //pergunta11
        System.out.println();
        sistema.restaurantsInBoroughs(); //pergunta12        
    }
}


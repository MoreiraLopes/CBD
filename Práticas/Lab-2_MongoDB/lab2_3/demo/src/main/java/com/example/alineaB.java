package com.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Projections;

import com.mongodb.client.FindIterable;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;


import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;


class SystemB{

    private MongoCollection<Document> collection;

     public SystemB() {
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

     public void createIndexes() {
        try {
            collection.createIndex(Indexes.ascending("gastronomia"));
            collection.createIndex(Indexes.ascending("localidade"));
            collection.createIndex(Indexes.text("nome"));
        } catch (Exception e) {
            System.err.println("Erro ao criar índices: " + e);
        }
    }
    

    public void searchWithIndexes() {
        System.out.println("Pesquisa com Índices");
        System.out.println("Liste o nome, a localidade e a gastronomia dos restaurantes que pertencem ao Bronx e cuja gastronomia é do tipo \"American\" ou \"Chinese\".");

        long startWithIndexes = System.nanoTime();

        Bson filter = Filters.and(
            Filters.eq("localidade", "Bronx"),
            Filters.in("gastronomia", Arrays.asList("American", "Chinese"))
        );

        Bson projection = Projections.fields(
            Projections.include("nome", "localidade", "gastronomia"),
            Projections.excludeId()
        );

        FindIterable<Document> docs = collection.find(filter).projection(projection);

        for (Document doc : docs) {
            System.out.println(doc.toJson());
        }

        long endWithIndexes = System.nanoTime();

        System.out.println("Duração nas pesquisas com índices: " + (endWithIndexes - startWithIndexes) + " nanos");
    }

    public void searchWithoutIndexes() {
        System.out.println("Pesquisa sem Índices");
        System.out.println("Liste o nome, a localidade e a gastronomia dos restaurantes que pertencem ao Bronx e cuja gastronomia é do tipo \"American\" ou \"Chinese\".");

        long startWithoutIndexes = System.nanoTime();

        Bson filter = Filters.and(
            Filters.eq("localidade", "Bronx"),
            Filters.in("gastronomia", Arrays.asList("American", "Chinese"))
        );

        Bson projection = Projections.fields(
            Projections.include("nome", "localidade", "gastronomia"),
            Projections.excludeId()
        );

        FindIterable<Document> docs = collection.find(filter).projection(projection);

        for (Document doc : docs) {
            System.out.println(doc.toJson());
        }

        long endWithoutIndexes = System.nanoTime();

        System.out.println("Duração nas pesquisas sem índices: " + (endWithoutIndexes - startWithoutIndexes) + " nanos");
    }

}

public class alineaB {
    
    public static void main( String[] args )
    {
        SystemB sistema = new SystemB();
        System.out.println();
        sistema.searchWithoutIndexes();
        System.out.println();
        sistema.createIndexes();
        sistema.searchWithIndexes();
        System.out.println();
    }
}
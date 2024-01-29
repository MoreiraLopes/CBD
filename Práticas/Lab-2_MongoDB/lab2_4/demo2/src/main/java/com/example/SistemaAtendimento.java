package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


import com.mongodb.client.FindIterable;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

class SistemaAtendimentoA {
    private static final int LIMIT = 10; // Limite máximo de produtos por timeslot
    private static final int TIMESLOT = 60; // Janela temporal em segundos

    private MongoClient mongoClient;
    private MongoCollection<Document> pedidosCollection;

    public SistemaAtendimentoA() {

        try {
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("atendimento");
            pedidosCollection = database.getCollection("pedidos");
        } catch (MongoException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (pedidosCollection != null) {
            cleanOldOrders(pedidosCollection);
        }
    }


    public void registarPedido(String username, String product) {
        Document user = pedidosCollection.find(new Document("username", username)).first();

        if (user == null) {
            Document newUser = new Document("username", username);
            newUser.append("pedidos", new ArrayList<String>());

            Document pedido1 = new Document("product", product);
            pedido1.append("timestamp", System.currentTimeMillis()+ TIMESLOT * 60 * 1000);

            newUser.getList("pedidos", Document.class).add(pedido1);

            pedidosCollection.insertOne(newUser);

            
            System.out.println(username + ", o seu pedido foi registado com sucesso!");
        
        
        }
        else{
            List<Document> pedidos = user.getList("pedidos", Document.class);
            if (pedidos.size() >= LIMIT) {
                System.out.println(username + " , atingiu o limite de pedidos por timeslot!");
            } else {
                Document pedido = new Document("product", product);
                pedido.append("timestamp", System.currentTimeMillis() + TIMESLOT * 60 * 1000);

                pedidos.add(pedido);
                pedidosCollection.updateOne(new Document("username", username), new Document("$set", new Document("pedidos", pedidos)));
                
                if(pedidos.size() == LIMIT){
                    System.out.println(username + ", o seu pedido foi registado com sucesso! Atingiu o limite de pedidos por timeslot!");
                }
                else{
                    System.out.println(username + ", o seu pedido foi registado com sucesso!");
                }
                
            }
        }
    }
    private static void cleanOldOrders(MongoCollection<Document> collection) {
        FindIterable<Document> utilizadores = collection.find();
        

        for (Document utilizador : utilizadores) {
            System.out.println("Utilizadores: "+utilizador);
            List<Document> pedidos = utilizador.getList("pedidos", Document.class);
            List<Document> pedidostoRemove = new ArrayList<>();

            for (Document pedido : pedidos) {
                long timestamp = pedido.getLong("timestamp");

                if (System.currentTimeMillis() > timestamp) {
                    pedidostoRemove.add(pedido);
                }
            }
            System.out.println("Pedidos a remover: "+pedidostoRemove);

            pedidos.removeAll(pedidostoRemove);

           
           if (pedidos.isEmpty()) {
            collection.deleteOne(new Document("_id", utilizador.getObjectId("_id")));
        } else {
            collection.updateOne(new Document("_id", utilizador.getObjectId("_id")),
                    new Document("$set", new Document("pedidos", pedidos)));
        }
        }
    }
}


public class SistemaAtendimento {
    public static void main(String[] args) {
        SistemaAtendimentoA sistema = new SistemaAtendimentoA();

        System.out.println("Sistema de atendimento iniciado!");
        System.out.println();
        System.out.println("O sistema atende, para cada utilizador, um máximo de 10 produtos diferentes a cada 60 minutos.");


        for(int i=0; i<10; i++){
            sistema.registarPedido("Manel", "Couves");
            
        }
        
        for(int i=0; i<10; i++){
            sistema.registarPedido("Iva", "Cenouras");
            
        }

        sistema.registarPedido("Manel", "Cenouras");
        sistema.registarPedido("Iva", "Couves");
        sistema.registarPedido("John", "Batatas");
        sistema.registarPedido("John", "Cenouras");
        
        
    }
}


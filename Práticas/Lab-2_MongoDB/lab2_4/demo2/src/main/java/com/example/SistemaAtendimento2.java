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

class SistemaAtendimentoB {
    private static final int LIMIT = 20; // Limite máximo de produtos por timeslot
    private static final int TIMESLOT = 60; // Janela temporal em segundos

    private MongoClient mongoClient;
    private MongoCollection<Document> pedidosCollection;

    public SistemaAtendimentoB() {

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


    public void registarPedido(String username, String product, int quantity) {
        if(quantity <= LIMIT){
            
        
            Document user = pedidosCollection.find(new Document("username", username)).first();

            if (user == null) {
                Document newUser = new Document("username", username);
                newUser.append("pedidos", new ArrayList<String>());

                Document pedido1 = new Document("product", product);
                pedido1.append("timestamp", System.currentTimeMillis()+ TIMESLOT * 60 * 1000);
                pedido1.append("quantity", quantity);

                newUser.getList("pedidos", Document.class).add(pedido1);

                pedidosCollection.insertOne(newUser);

                
                System.out.println(username + ", o seu pedido foi registado com sucesso!");
            
            
            }
            else{
                List<Document> pedidos = user.getList("pedidos", Document.class);

                int totalQuantity = 0;
                for (Document pedido : pedidos) {
                    totalQuantity += pedido.getInteger("quantity", 0);
                }
                int newTotalQuantity=totalQuantity+quantity;

                if (newTotalQuantity > LIMIT) {
                    System.out.println(username + " , atingiu o limite de pedidos por timeslot!");
                } else {
                    Document pedido = new Document("product", product);
                    pedido.append("timestamp", System.currentTimeMillis() + TIMESLOT * 60 * 1000);
                    pedido.append("quantity", quantity);

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
        else{
            System.out.println("O limite de produtos por timeslot é 10!");
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


public class SistemaAtendimento2 {
    public static void main(String[] args) {
        SistemaAtendimentoB sistema = new SistemaAtendimentoB();

        System.out.println("Sistema de Atendimento B");
        System.out.println();

        sistema.registarPedido("Iva", "Peras", 5);
        sistema.registarPedido("Iva", "Peras", 5);
        sistema.registarPedido("Iva", "Peras", 3);
        sistema.registarPedido("John", "Agua", 10);
        sistema.registarPedido("John", "Agua", 10);
        sistema.registarPedido("Iva", "Maca", 3);
        sistema.registarPedido("John", "Almondegas", 3);
        sistema.registarPedido("Iva", "Agua", 4);
        sistema.registarPedido("Iva", "Maca", 3);
        
        
        
    }
}


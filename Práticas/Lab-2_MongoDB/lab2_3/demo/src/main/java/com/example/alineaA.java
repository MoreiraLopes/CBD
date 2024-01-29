package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.FindIterable;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


class Sistema {

    private MongoCollection<Document> collection;

     public Sistema() {
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
    public void pesquisarRegistosById(String id) {
        ObjectId objectId = new ObjectId(id);

        Document filtro = new Document("_id", objectId);
        FindIterable<Document> resultados = collection.find(filtro);
        


        try (MongoCursor<Document> cursor = resultados.iterator()) {
            if (cursor.hasNext()) {
                while (cursor.hasNext()) {
                    System.out.println();

                    Document doc = cursor.next();
                    System.out.println("Registo encontrado:");
                    System.out.println("ID: " + doc.getObjectId("_id"));
                    System.out.println("Nome: " + doc.getString("nome"));
                    System.out.println("Localidade: " + doc.getString("localidade"));
                    System.out.println("Gastronomia: " + doc.getString("gastronomia"));
                    

                    System.out.println();
                }
            } else {
                System.out.println("Nenhum registo encontrado para o id: " + id);
            }
        }
    }

    public void pesquisarRegistosByName(String nome) {
        Document filtro = new Document("nome", nome);
        FindIterable<Document> resultados = collection.find(filtro);

        try (MongoCursor<Document> cursor = resultados.iterator()) {
            if (cursor.hasNext()) {
                while (cursor.hasNext()) {
                    System.out.println();

                    Document doc = cursor.next();
                    System.out.println("Registo encontrado:");
                    System.out.println("ID: " + doc.getObjectId("_id"));
                    System.out.println("Localidade: " + doc.getString("localidade"));
                    System.out.println("Gastronomia: " + doc.getString("gastronomia"));
                    System.out.println("Nome: " + doc.getString("nome"));

                    System.out.println();
                }
            } else {
                System.out.println("Nenhum registo encontrado para o nome: " + nome);
            }
        }
    }



   public void InserirRegisto(String nome, String localidade, String gastronomia) {
        if (nome == null || nome.isEmpty() || localidade == null || localidade.isEmpty() || gastronomia == null || gastronomia.isEmpty()) {
            System.out.println("Não é possível inserir o registo. Campos obrigatórios estão em falta.");
            return;
        }

        
        long existingDocumentsCount = collection.countDocuments(Filters.eq("nome", nome));
        if (existingDocumentsCount > 0) {
            System.out.println("Já existe um registo com o mesmo nome na coleção.");
            return;
        }

        
        Document documento = new Document("nome", nome)
                .append("localidade", localidade)
                .append("gastronomia", gastronomia);

        
        collection.insertOne(documento);

        System.out.println();
        System.out.println("Registo inserido com sucesso!");
        System.out.println();
    }
    
    public void EditarRegisto(String id, String novoNome, String novaLocalidade, String novaGastronomia) {
        
        if (id == null || id.isEmpty()) {
            System.out.println("Erro: O ID do documento a ser editado não foi fornecido.");
            return;
        }

        
        if (novoNome == null && novaLocalidade == null && novaGastronomia == null) {
            System.out.println("Erro: Nenhum campo de atualização fornecido.");
            return;
        }

        
        Bson filtro = Filters.eq("_id", new ObjectId(id));

        Document documentoAntes = collection.find(filtro).first();

        
        Document atualizacao = new Document();
        if (novoNome != null && !novoNome.isEmpty()) {
            atualizacao.append("nome", novoNome);
        }
        if (novaLocalidade != null && !novaLocalidade.isEmpty()) {
            atualizacao.append("localidade", novaLocalidade);
        }
        if (novaGastronomia != null && !novaGastronomia.isEmpty()) {
            atualizacao.append("gastronomia", novaGastronomia);
        }

        
        UpdateResult resultado = collection.updateOne(filtro, new Document("$set", atualizacao));

        Document documentoDepois = collection.find(filtro).first();

        if (resultado.getModifiedCount() > 0) {
            System.out.println("Registo editado com sucesso!");

            System.out.println("Estado anterior:");
            System.out.println(documentoAntes.toJson());

            System.out.println("Estado posterior:");
            System.out.println(documentoDepois.toJson()+"\n");
        } else {
            System.out.println("Nenhum registo foi encontrado para editar.");
        }
    }


}



public class alineaA 
{
    public static void main( String[] args )
    {
        Sistema sistema = new Sistema();

        sistema.pesquisarRegistosById("652d4537cd7a8c3a1e73c8a1");
        sistema.pesquisarRegistosByName("Steve Chu'S Deli & Grocery");
        sistema.InserirRegisto("Magarenha", "Viseu", "Portuguese");
        sistema.pesquisarRegistosByName("Magarenha");
        sistema.EditarRegisto("653a51122378de2be5d2a8bd", "Tasca do Manel", "Aveiro", "Portuguese"); //editei o da Magarenha
        sistema.pesquisarRegistosById("653a51122378de2be5d2a8bd");
    }
}
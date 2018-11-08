/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pessoa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import connection.ParearConexao;
import java.util.Arrays;
import org.bson.Document;
/**
 *
 * @author Allan
 */
public class CrudAgenda {
    
    
    public static boolean inserirPessoa(Pessoa pessoa){
        MongoCollection<org.bson.Document> collection = ParearConexao.conectar().getCollection("agenda");
        Document doc = new Document("nome", pessoa.getNome())
                .append("telefone", pessoa.getTelefone())
                .append("email", pessoa.getEmail())
                .append("endereco", Arrays.asList(pessoa.getLogradouro(),
                        pessoa.getNumero(),pessoa.getComplemento(),
                        pessoa.getCidade(),pessoa.getEstado()));
        
        
        collection.insertOne(doc);
        return true;
    }
    
    public static boolean removerPessoa(String nome,String email,String telefone){
        MongoCollection<org.bson.Document> collection = ParearConexao.conectar().getCollection("agenda");
        DeleteResult deleteresult = collection.deleteOne(and(eq("nome",nome),eq("email",email),eq("telefone",telefone)));
        return (deleteresult.getDeletedCount() == 1);
        
    }
    
    public static boolean atualizarCadastro(String valorantigo,String valoratual, int option){
        MongoCollection<org.bson.Document> collection = ParearConexao.conectar().getCollection("agenda");
        switch(option){
            case 1:{
                collection.updateOne(eq("nome", valorantigo ), new Document("$set", new Document("nome", valoratual)));
                break;
            }
            case 2:{
                collection.updateOne(eq("telefone", valorantigo ), new Document("$set", new Document("telefone", valoratual)));
                break;
            }
            case 3:{
                collection.updateOne(eq("email", valorantigo ), new Document("$set", new Document("email", valoratual)));
                break;
            }
        }
        return true;
    }
    
    public static void listarAgenda(){
        MongoCollection<org.bson.Document> collection = ParearConexao.conectar().getCollection("agenda");
        try (MongoCursor <org.bson.Document> cursor = collection.find().iterator()) {
        System.out.println("*******************************RESULTADO DA PESQUISA****************************");
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        }
                
    }
    
    public static void listarAgenda(String nome){
        MongoCollection<org.bson.Document> collection = ParearConexao.conectar().getCollection("agenda");
        try (MongoCursor <org.bson.Document> cursor = collection.find(eq("nome",nome)).iterator()) {
        System.out.println("*******************************RESULTADO DA PESQUISA****************************");
            while(cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        }
    }
    
    
    
}

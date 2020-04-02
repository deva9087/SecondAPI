package com.hkr;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import resource.myResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/h")
public class helloTest {
    MongoClientURI uri = new MongoClientURI("mongodb+srv://Deva:incorrect1@deva-gxfnf.mongodb.net/test?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("kaiburr");
    MongoCollection<Document> collection = database.getCollection("server");

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<myResource> getMessage() {
        FindIterable<Document> temp = collection.find();
        List<myResource> allDocs = new ArrayList<myResource>();
        for (Document doc:temp) {
            myResource resource = new myResource();
            String name = doc.getString("name");
            if (!(name.equals(null))) {
                resource.setName(name);
            }
            System.out.println(name);
            String language = doc.getString("language");
            if (!(language.equals(null))) {
                resource.setLanguage(language);
            }
            System.out.println(language);
            String framework = doc.getString("framework");
            if (!(framework.equals(null))) {
                resource.setFramework(framework);
            }
            System.out.println(framework);
            String id = doc.getString("id");
            if (!(id.equals(null))) {
                resource.setId(id);
            }
            System.out.println(id);
            allDocs.add(resource);
            System.out.println(resource.getFramework() + "  " + resource.getId() + " " +resource.getLanguage() + " " + resource.getName());
        }
        return allDocs;
    }
}

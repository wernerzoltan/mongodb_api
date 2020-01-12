package com.example.mongoapi;

import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public List<Document> HelloWorld() {

        Connector connector = new Connector();
        return connector.mongoConnector();

    }

}
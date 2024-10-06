package com.ddc.projects.java11.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Main {
    public static void main(String[] args) {
        final String uriString = "mongodb://$[username]:$[password]@$[hostlist]/$[database]?authSource=$[authSource]";
        MongoClient mongoClient = MongoClients.create(uriString);
    }
}

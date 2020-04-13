package com.ddc.projects.unittest.mockito;

public class FriendsCollection {
    // MongoCollection friends;

    public FriendsCollection() {
        /**
        try {
            //DB db = new MongoClient().getDB("friendships");
            friends = new Jongo(db).getCollection("friends");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage());
        }
         */
    }

    public Person findByName(String name) {
        return null;
        //return friends.findOne("{_id: #}", name).as(Person.class);
    }

    public void save(Person p) {
        System.out.println("Person saved");
        //friends.save(p);
    }
}

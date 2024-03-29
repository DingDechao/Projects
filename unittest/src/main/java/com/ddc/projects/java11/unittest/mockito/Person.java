package com.ddc.projects.java11.unittest.mockito;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;

    private List<String> friends;

    public Person() { }

    public Person(String name) {
        this.name = name;
        friends = new ArrayList<>();
    }

    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String friend) {
        if (!friends.contains(friend)) friends.add(friend);
    }

    @Override
    public String toString() {
        return String.format("NAME: %1$s FRIENDS: %2$s", name, friends);
    }
}

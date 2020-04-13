package com.ddc.projects.unittest.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FriendshipsTest {

    @InjectMocks
    FriendshipsMongo friendshipsMongo;

    @Mock
    FriendsCollection friendsCollection;

    @Test
    public void before(){
        Person person = new Person("person1");
        doReturn(person).when(friendsCollection).findByName("person1");
        assertThat(friendsCollection.findByName("person1")).isEqualTo(person);
    }
}

package com.example.hw_rest.repository;

import com.example.hw_rest.service.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class UserRepository {

    private Map<String, String> userMap;
    private Map<String, List<Authorities>> authoritiesMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
        this.authoritiesMap = new HashMap<>();
        createUsersAuthorities ("admin", "password123",
                Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        createUsersAuthorities ("user", "user1111", Arrays.asList(Authorities.READ, Authorities.WRITE));
        createUsersAuthorities ("quest", "password123", Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        if (userMap.containsKey(user) && userMap.get(user).equals(password))
            list = authoritiesMap.get(user);
        return list;
    }

    private void createUsersAuthorities(String name, String password, List<Authorities> list) {
        userMap.put(name, password);
        authoritiesMap.put(name, list);
    }
}

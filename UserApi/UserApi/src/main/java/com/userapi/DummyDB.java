package com.userapi;

import java.util.ArrayList;
import java.util.List;

public class DummyDB {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Jan", "Kowalski", 44));
        users.add(new User("Marta", "Kowalska", 11));
        users.add(new User("Zuzanna", "Bąk", 45));
    }
}

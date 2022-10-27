package org.example.three;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private static final Service service = new Service();

    public static void main(String[] args) {
        service.addFriends(14, 15, 13);
        service.addFriends(15, 13);
        service.addFriends(13, 15);
        service.addFriends(1, 14, 15, 13);

        Observable<UserFriend> friends = service.getFriends(1);
        friends.forEach(System.out::println);

        Observable<UserFriend> friends1 = service.addAndGetUsers(1, 2, 4, 5);
        friends1.forEach(System.out::println);
    }

}

package org.example.three;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Service {

//    private Observable<UserFriend> array;
    private final List<UserFriend> array;

    public Service() {
        array = new ArrayList<>();
    }

    public void addFriends(int userId, int... friendIDs) {
        for (int friendID : friendIDs) {
            array.add(new UserFriend(userId, friendID));
        }
    }

    public void addUsers(int... IDs) { //Возможно это имелось ввиду
        for (int id : IDs) {
            array.add(new UserFriend(id));
        }
    }

    public Observable<UserFriend> getFriends(int userId) {
        return Observable.fromIterable(array).filter(u -> u.getUserId() == userId);
    }

}

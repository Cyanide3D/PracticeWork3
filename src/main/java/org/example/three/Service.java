package org.example.three;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

import java.util.*;
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

    public Observable<UserFriend> addAndGetUsers(int uID, int... IDs) { //Возможно это имелось ввиду
        return getFriends(uID).concatWith(Observable.fromIterable(Arrays.stream(IDs).boxed().collect(Collectors.toList())).map(e -> {
            UserFriend uf = new UserFriend(e);
            array.add(uf);
            return uf;
        }));
    }


    public Observable<UserFriend> getFriends(int userId) {
        return Observable.fromIterable(array).filter(u -> u.getUserId() == userId);
    }

}

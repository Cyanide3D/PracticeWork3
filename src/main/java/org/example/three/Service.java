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

    private final Observable<UserFriend> array;

    public Service(int... IDs) {
        array = Observable.fromIterable(Arrays.stream(IDs).boxed().collect(Collectors.toList())).map(UserFriend::new); //Получаем в конструкторе ID'шники, формируем из них List, а из него уже Observable.
    }

    public Observable<UserFriend> getFriends(int userId) {
        return array.filter(u -> u.getUserId() == userId); //Фильтруем Observable по userId и отдаём результат пользователю
    }

}

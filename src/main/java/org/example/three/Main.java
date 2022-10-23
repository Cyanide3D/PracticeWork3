package org.example.three;

import io.reactivex.rxjava3.core.Observable;

public class Main {

    public static void main(String[] args) {
        Service service = new Service(1,14,16,76,45); //Не очень понял что в этом задании делать надо, но вроде ТЗ соответствует
        Observable<UserFriend> friends = service.getFriends(14);
    }

}

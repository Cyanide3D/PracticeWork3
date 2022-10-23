package org.example.two;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        first(); //ВАЖНО!!! тут надо поменять в зависимости от задания
    }

    private static void first() {
        Observable<Integer> s1 = Observable.fromStream(new Random().ints((int) (Math.random() * 1000)).boxed()); //Делаем поток с рандомным числом элементов (от 1 до 1000) и пихаем его в Observable (Observable - это некий аналог стандартных джавовских потоков)
        s1.count() //Получаем объект с кол-вом элементов в потоке
                .flatMapObservable(Observable::fromArray) //Превращаем этот объект обратно в Observable
                .forEach(System.out::println);  //Выводим его на экран
    }

    private static void second() {
        Observable<Integer> s1 = Observable.fromStream(new Random().ints((int) (Math.random() * 1000), 1000).boxed());
        Observable<Integer> s2 = Observable.fromStream(new Random().ints((int) (Math.random() * 1000), 1000).boxed()); //Делаем 2 разных потока
        Observable.fromArray(s1, s2).observeOn(Schedulers.io()).flatMap(e -> e).forEach(System.out::println); //Объединяем потоки в один
    }

    private static void three() {
        Observable<Integer> s1 = Observable.fromStream(new Random().ints((int) (Math.random() * 1000)).boxed());
        s1.takeLast(1).forEach(System.out::println); //Просто берём последний элемент
    }

}

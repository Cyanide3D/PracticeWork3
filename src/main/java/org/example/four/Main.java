package org.example.four;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue(); //Генератор и очередь тут из одной из предыдуших работ

        PublishSubject<File> ps = PublishSubject.create(); //Подписываем на паблишер обработчики
        ps.subscribe(new XLSHandler());
        ps.subscribe(new JSONHandler());
        ps.subscribe(new XMLHandler());

        new Thread(() -> {
            Generator generator = new Generator(queue);
        }).start();


        while (true) {
            ps.onNext(queue.getFile()); //Просто по возможности забираем файлы из очереди, как только там файлы закончатся текущий поток впадёт в спячку до того момента, как появится новый поток
        }

    }

}

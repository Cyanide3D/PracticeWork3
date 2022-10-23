package org.example.one;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        COSensor coSensor = new COSensor();
        TempSensor tempSensor = new TempSensor();

        PublishSubject<SensorData> pc = PublishSubject.create();
        pc.subscribe(new Alarm()); //Подписываем нашу сигналку на оповещения

        while (true) {
            pc.onNext(new SensorData(tempSensor.getData(), coSensor.getData())); //Раз в секунду триггерим "подписчиков"(сигналку)
            Thread.sleep(1000);
        }
    }

}

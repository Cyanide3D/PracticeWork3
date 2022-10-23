package org.example.one;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Alarm implements Observer<SensorData> {

    private final int MAC_CO2=70;
    private final int MAX_TEMP=25;

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull SensorData sensorData) { //Метод, который сабскрайбер вызывать будет
        int co2 = sensorData.getCOLevel();
        int temp = sensorData.getTemp();
        if (co2 > MAC_CO2 && temp > MAX_TEMP) {
            System.out.println("ALARM!");
        } else if (co2 > MAC_CO2) {
            System.out.println("Too high level of CO2!");
        } else if (temp > MAX_TEMP) {
            System.out.println("Too high level of temperature!");
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}

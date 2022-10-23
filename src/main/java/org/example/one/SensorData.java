package org.example.one;

public class SensorData {

    private int temp;
    private int COLevel;

    public SensorData(int temp, int COLevel) {
        this.temp = temp;
        this.COLevel = COLevel;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getCOLevel() {
        return COLevel;
    }

    public void setCOLevel(int COLevel) {
        this.COLevel = COLevel;
    }
}

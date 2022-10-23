package org.example.four;

import java.util.concurrent.ConcurrentLinkedQueue;


//Это скверная реализация блокирующей очереди
//Если мы пытаемся взять файл, но очередь пуста, то поток, который пытается взять файл засыпает, проснётся он только тогда, когда какой нибудь другой поток добавит файл в очередь
//Если мы добавляем файл, и в очереди оказывается 5 и более файлов, то поток, добавляющий файлы засыпает, и пробуждается только тогда, когда другой поток заберёт файл
public class Queue {

    private final java.util.Queue<File> queue = new ConcurrentLinkedQueue<>();
    private final Object generatorMonitor;
    private final Object workerMonitor;

    public Queue() {
        this.generatorMonitor = new Object();
        this.workerMonitor = new Object();
    }

    public File getFile() {
        synchronized (workerMonitor) {
            if (queue.isEmpty()) {
                try {
                    workerMonitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (generatorMonitor) {
            generatorMonitor.notify();
        }
        return queue.poll();
    }

    public void add(File file) {
        synchronized (generatorMonitor) {
            queue.add(file);
            System.out.println("Queue size " + size());
            if (size() >= 5) {
                try {
                    generatorMonitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (workerMonitor) {
            workerMonitor.notify();
        }
    }

    public int size() {
        return queue.size();
    }

}

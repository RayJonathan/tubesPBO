package Controller;

import Models.QueueTable;

public class SingletonQueue {

    private static SingletonQueue instance;
    private QueueTable currentQueue;

    public static SingletonQueue getInstance() {
        if (instance == null) {
            instance = new SingletonQueue();
        }
        return instance;
    }

    public QueueTable getcurrentQueue() {
        return currentQueue;
    }

    public void setcurrentQueue(QueueTable currentQueue) {
        this.currentQueue = currentQueue;
    }

}
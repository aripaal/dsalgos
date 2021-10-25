package designpatterns;

import java.util.*;

public class ObserverPattern {
    public static void main(String ...args){
        Subject s = new Subject();
        ObserverA observerA = new ObserverA(s);
        s.attach(observerA);
        s.update(5);
    }
}

class Subject{
    int x;
    List<Observer> observers = new LinkedList<>();
    public void attach(Observer o){
        observers.add(o);
    }
    public void update(int value){
        x = value;
        notifyAllObservers();
    }
    void notifyAllObservers(){
        for(Observer o: observers)
            o.update();
    }
}

interface Observer{
    void update();
}

class ObserverA implements Observer{
    Subject s;

    public ObserverA(Subject s) {
        this.s = s;
    }

    @Override
    public void update() {
        System.out.println("OserverA: State has changed :"+s.x);
    }
}
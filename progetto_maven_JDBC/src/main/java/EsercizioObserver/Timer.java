package EsercizioObserver;

import java.util.ArrayList;
import java.util.List;

public class Timer implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void dettach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer ob: observers){
            ob.update();
        }
    }
}

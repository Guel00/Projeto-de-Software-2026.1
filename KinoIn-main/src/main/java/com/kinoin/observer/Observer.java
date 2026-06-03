package com.kinoin.observer;

// Interface para quem observa (quem recebe o alerta)
public interface Observer {
    void update(String message);
}

// Interface para quem é observado (o filme)
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

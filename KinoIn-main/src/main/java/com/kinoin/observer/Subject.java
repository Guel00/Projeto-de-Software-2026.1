package com.kinoin.model;

import com.kinoin.enums.MovieStatus;
import com.kinoin.observer.*;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Subject {
    private String title;
    private MovieStatus status;
    private List<Observer> observers = new ArrayList<>();

    // ... construtores e outros métodos ...

    public void setStatus(MovieStatus status) {
        this.status = status;
        if (status == MovieStatus.NOW_SHOWING) {
            notifyObservers(); // Dispara o alerta!
        }
    }

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update("O filme '" + title + "' agora está em cartaz!");
        }
    }
}

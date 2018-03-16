package com.nespresso.exercise.piramid;

public class Pyramid {
    private Layers layers;

    public Pyramid() {
        this.layers = new Layers();
    }

    public void addLayer(String s) {
        this.layers.addLayer(s);
    }

    public String print() {
        return this.layers.print();
    }
}

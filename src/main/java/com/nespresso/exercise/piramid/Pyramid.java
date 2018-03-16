package com.nespresso.exercise.piramid;

import com.nespresso.exercise.piramid.layer.Layers;

public class Pyramid {
    private Layers layers;

    public Pyramid() {
        this.layers = new Layers();
    }

    public void addLayer(String s) {
        this.layers.addLayer(s);
    }

    public String print() {
        return this.layers.draw();
    }
}

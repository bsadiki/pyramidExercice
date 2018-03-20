package com.nespresso.exercise.piramid;

import com.nespresso.exercise.piramid.layer.LayerFactory;
import com.nespresso.exercise.piramid.layer.Layers;

public class Pyramid {
    private Layers layers;

    public Pyramid() {
        this.layers = new Layers();
    }

    public void addLayer(String s) {
        this.layers.addLayer(LayerFactory.createLayer(s));
}

    public String print() {
        return this.layers.draw();
    }
}

package com.nespresso.exercise.piramid;

import java.util.List;

public class CollapceAndAddLayerStrategy implements AddLayerStrategy {
    @Override
    public void addLayer(List<Layer> layers, Layer newLayer) {
        layers.remove(layers.size() - 1);
        layers.add(newLayer);
    }
}

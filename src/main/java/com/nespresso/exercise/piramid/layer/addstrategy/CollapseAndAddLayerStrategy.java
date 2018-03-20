package com.nespresso.exercise.piramid.layer.addstrategy;

import com.nespresso.exercise.piramid.layer.Layer;

import java.util.List;

public class CollapseAndAddLayerStrategy implements AddLayerStrategy {
    @Override
    public void addLayer(List<Layer> layers, Layer newLayer) {
        layers.remove(layers.size() - 1);
        layers.add(newLayer);
    }
}
package com.nespresso.exercise.piramid.layer.addstrategy;

import com.nespresso.exercise.piramid.layer.Layer;

import java.util.List;

public class AddLayerStrategyImpl implements AddLayerStrategy {
    @Override
    public void addLayer(List<Layer> layers, Layer newLayer) {
        layers.add(newLayer);
    }
}

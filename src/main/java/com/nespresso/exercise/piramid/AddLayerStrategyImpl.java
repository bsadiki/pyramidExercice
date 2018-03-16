package com.nespresso.exercise.piramid;

import java.util.List;

public class AddLayerStrategyImpl implements AddLayerStrategy {
    @Override
    public void addLayer(List<Layer> layers, Layer newLayer) {
        layers.add(newLayer);
    }
}

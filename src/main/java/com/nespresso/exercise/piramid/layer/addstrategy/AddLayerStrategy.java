package com.nespresso.exercise.piramid.layer.addstrategy;

import com.nespresso.exercise.piramid.layer.Layer;

import java.util.List;

public interface AddLayerStrategy {
    void addLayer(List<Layer> layers, Layer newLayer);
}

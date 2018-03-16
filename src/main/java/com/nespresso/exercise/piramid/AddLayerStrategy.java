package com.nespresso.exercise.piramid;

import java.util.List;

public interface AddLayerStrategy {
    void addLayer(List<Layer> layers, Layer newLayer);
}

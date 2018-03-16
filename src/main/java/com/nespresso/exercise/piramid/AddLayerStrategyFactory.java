package com.nespresso.exercise.piramid;

import java.util.List;

public class AddLayerStrategyFactory {
    static AddLayerStrategy createAddLayerStrategy(List<Layer> layers, Layer newLayer){
        if (!layers.isEmpty()) {
            Layer lastLayer = layers.get(layers.size() - 1);
            if (newLayer.length() > lastLayer.length()) {
                return new CollapceAndAddLayerStrategy();
            } else if (newLayer.length() == lastLayer.length() && newLayer.hasSameOrBetterQualityThan(lastLayer)) {
                return new CollapceAndAddLayerStrategy();
            } else {
                return new AddLayerStrategyImpl();
            }
        } else {
            return new AddLayerStrategyImpl();
        }
    }
}

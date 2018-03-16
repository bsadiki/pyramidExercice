package com.nespresso.exercise.piramid.layer;

import java.util.List;

public class AddLayerStrategyFactory {
    static AddLayerStrategy createAddLayerStrategy(List<Layer> layers, Layer newLayer){
        if (!layers.isEmpty()) {
            Layer lastLayer = layers.get(layers.size() - 1);
            if (newLayer.length() > lastLayer.length()) {
                return new CollapseAndAddLayerStrategy();
            } else if (newLayer.length() == lastLayer.length() && newLayer.hasSameOrBetterQualityThan(lastLayer)) {
                return new CollapseAndAddLayerStrategy();
            } else {
                return new AddLayerStrategyImpl();
            }
        } else {
            return new AddLayerStrategyImpl();
        }
    }
}

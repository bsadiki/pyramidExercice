package com.nespresso.exercise.piramid.layer;


public class AddLayerStrategyFactory {
    static AddLayerStrategy createAddLayerStrategy(Layer lastLayer, Layer newLayer) {
        if (lastLayer == null || lastLayer.canHold(newLayer)) {
            return new AddLayerStrategyImpl();
        } else {
            return new CollapseAndAddLayerStrategy();
        }
    }
}

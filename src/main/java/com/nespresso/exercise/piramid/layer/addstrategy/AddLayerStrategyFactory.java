package com.nespresso.exercise.piramid.layer.addstrategy;


import com.nespresso.exercise.piramid.layer.Layer;

public class AddLayerStrategyFactory {
    public static AddLayerStrategy createAddLayerStrategy(Layer lastLayer, Layer newLayer) {
        if (lastLayer == null || lastLayer.canHold(newLayer)) {
            return new AddLayerStrategyImpl();
        } else {
            return new CollapseAndAddLayerStrategy();
        }
    }
}

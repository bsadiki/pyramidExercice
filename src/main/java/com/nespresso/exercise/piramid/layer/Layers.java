package com.nespresso.exercise.piramid.layer;

import com.nespresso.exercise.piramid.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class Layers implements Drawable {
    private List<Layer> layers;
    private AddLayerStrategy addLayerStrategy;

    public Layers() {
        this.layers = new ArrayList<>();
    }

    public void addLayer(String s) {
        Layer newLayer = LayerFactory.createLayer(s);
        if(newLayer!=null){
            this.addLayerStrategy = AddLayerStrategyFactory.createAddLayerStrategy(this.layers, newLayer);
            this.addLayerStrategy.addLayer(this.layers, newLayer);
        }
    }

    private int baseLength() {
        return layers.get(0).length();
    }

    @Override
    public String draw() {
        StringBuilder pyramidDrawBuilder = new StringBuilder();
        ListIterator<Layer> layerIterator = this.layers.listIterator();
        int previousLineLength = 0;
        while (layerIterator.hasNext()) {
            Layer layer = layerIterator.next();
            pyramidDrawBuilder.append(layer.draw(this.baseLength(), previousLineLength));
            previousLineLength = layer.length();
            if (layerIterator.hasNext())
                pyramidDrawBuilder.append("\n");
        }
        return pyramidDrawBuilder.reverse().toString();
    }
}

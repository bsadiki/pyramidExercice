package com.nespresso.exercise.piramid.layer;

import com.nespresso.exercise.piramid.Drawable;
import com.nespresso.exercise.piramid.layer.addstrategy.AddLayerStrategy;
import com.nespresso.exercise.piramid.layer.addstrategy.AddLayerStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Layers implements Drawable {
    private List<Layer> layers;
    private AddLayerStrategy addLayerStrategy;

    public Layers() {
        this.layers = new ArrayList<>();
    }

    public void addLayer(Layer newLayer) {
        if (newLayer != null) {
            this.addLayerStrategy = AddLayerStrategyFactory.createAddLayerStrategy(lastLayer(), newLayer);
            this.addLayerStrategy.addLayer(this.layers, newLayer);
        }
    }

    private Layer lastLayer(){
        if(this.layers.isEmpty())
            return null;
        return this.layers.get(this.layers.size()-1);
    }
    @Override
    public String draw() {
        StringBuilder pyramidDrawBuilder = new StringBuilder();
        ListIterator<Layer> layerIterator = this.layers.listIterator();
        Layer previousLineLength = null;
        while (layerIterator.hasNext()) {
            Layer layer = layerIterator.next();
            pyramidDrawBuilder.append(layer.draw(this.layers.get(0), previousLineLength));
            previousLineLength = layer;
            if (layerIterator.hasNext())
                pyramidDrawBuilder.append("\n");
        }
        return pyramidDrawBuilder.reverse().toString();
    }
}

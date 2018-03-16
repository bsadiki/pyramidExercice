package com.nespresso.exercise.piramid;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Layers {
    private final static Pattern pattern = Pattern.compile("(\\d*) Slaves, (\\d*) Anks");
    private List<Layer> layers;
    private AddLayerStrategy addLayerStrategy;
    public Layers() {
        this.layers = new ArrayList<>();
    }

    void addLayer(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            int slaves = Integer.parseInt(matcher.group(1));
            int anks = Integer.parseInt(matcher.group(2));
            Layer newLayer = new Layer(slaves, anks);
            this.addLayerStrategy = AddLayerStrategyFactory.createAddLayerStrategy(this.layers,newLayer);
            this.addLayerStrategy.addLayer(this.layers, newLayer);
        }
    }

    public String print() {
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

    private int baseLength() {
        return layers.get(0).length();
    }
}

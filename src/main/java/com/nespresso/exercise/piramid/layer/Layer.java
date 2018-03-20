package com.nespresso.exercise.piramid.layer;

import com.nespresso.exercise.piramid.layer.block.Blocks;

public class Layer {
    private final Blocks blocks;

    Layer(Blocks blocks) {
        this.blocks = blocks;
    }

    public boolean canHold(Layer layer) {
        return this.length() > layer.length()
                || (this.length() == layer.length() && this.hasBetterQualityThan(layer));
    }

    private int length() {
        return this.blocks.length();
    }

    private boolean hasBetterQualityThan(Layer layer) {
        return ((this.isAHighQualityLayer() && !layer.isAHighQualityLayer()));
    }


    private boolean isAHighQualityLayer() {
        return (blocks.isAHighQualityBlock());
    }

    String draw(Layer baseLayer, Layer previousLayer) {
        StringBuilder layerDrawBuilder = new StringBuilder();
        int lengthDifferenceWithPreviousLayer = lengthDifferenceWithPreviousLayer(previousLayer);
        int lengthDifferenceWithBase = lengthDifferenceWithBase(baseLayer);
        layerDrawBuilder.append(extraLine(lengthDifferenceWithPreviousLayer, lengthDifferenceWithBase));
        layerDrawBuilder.append(blocks.draw());
        layerDrawBuilder.append(extraLine(lengthDifferenceWithPreviousLayer, lengthDifferenceWithBase).reverse());
        return layerDrawBuilder.toString();
    }

    private int lengthDifferenceWithPreviousLayer(Layer previousLayer) {
        if (previousLayer != null)
            return Math.max(0, previousLayer.length() - this.length());
        return 0;
    }

    private int lengthDifferenceWithBase(Layer baseLayer) {
        return Math.max(0, baseLayer.length() - this.length());
    }

    private StringBuilder extraLine(int lengthDifferenceWithPreviousLayer, int lengthDifferenceWithBase) {
        StringBuilder extraLineBuilder = new StringBuilder();
        for (int i = 0; i < (lengthDifferenceWithBase - lengthDifferenceWithPreviousLayer) / 2; i++) {
            extraLineBuilder.append(" ");
        }
        for (int i = 0; i < lengthDifferenceWithPreviousLayer / 2; i++) {
            extraLineBuilder.append("_");
        }
        return extraLineBuilder;
    }
}

package com.nespresso.exercise.piramid.layer;

import com.nespresso.exercise.piramid.layer.Block.Blocks;
import com.nespresso.exercise.piramid.layer.Block.BlocksFactory;

public class Layer {
    private final Blocks blocks;

    public Layer(int slaves, int anks) {
        blocks = BlocksFactory.createBlocks(slaves, anks);
    }

    String draw(int baseLength, int previousLayerLength) {
        StringBuilder layerDrawBuilder = new StringBuilder();
        int lengthDifferenceWithPreviousLayer = Math.max(0, previousLayerLength - this.length());
        int lengthDifferenceWithBase = Math.max(0, baseLength - this.length());
        layerDrawBuilder.append(extraLine(lengthDifferenceWithPreviousLayer, lengthDifferenceWithBase));
        layerDrawBuilder.append(blocks.draw());
        layerDrawBuilder.append(extraLine(lengthDifferenceWithPreviousLayer, lengthDifferenceWithBase).reverse());
        return layerDrawBuilder.toString();
    }

    int length() {
        return blocks.length();
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

    boolean hasSameOrBetterQualityThan(Layer layer) {
        return ((this.isAHighQualityLayer() && !layer.isAHighQualityLayer())
                || hasSameQuality(layer)
        );
    }

    private boolean hasSameQuality(Layer layer) {
        return ((this.isAHighQualityLayer() && layer.isAHighQualityLayer()) || (!this.isAHighQualityLayer() && !layer.isAHighQualityLayer()));
    }

    private boolean isAHighQualityLayer() {
        return (blocks.isAHighQualityBlock());
    }
}

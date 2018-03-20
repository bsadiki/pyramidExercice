package com.nespresso.exercise.piramid.layer.block;

import com.nespresso.exercise.piramid.Drawable;

import java.util.List;

public class Blocks implements Drawable {
    private final List<Block> blocks;

    Blocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public boolean isAHighQualityBlock() {
        return blocks.get(0) instanceof HighQualityBlock;
    }

    public int length() {
        return blocks.size();
    }

    @Override
    public String draw() {
        final StringBuilder drawBuilder = new StringBuilder();
        this.blocks.forEach(block -> drawBuilder.append(block.draw()));
        return drawBuilder.toString();
    }
}

package com.nespresso.exercise.piramid;

import java.util.List;

public class Blocks {
    private final List<Block> blocks;

    public Blocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public boolean isAHighQualityBlock() {
        return blocks.get(0) instanceof HighQualityBlock;
    }

    public String draw() {
        final StringBuilder drawBuilder = new StringBuilder();
        this.blocks.forEach(block -> drawBuilder.append(block.presentation()));
        return drawBuilder.toString();
    }

    public int length() {
        return blocks.size();
    }
}

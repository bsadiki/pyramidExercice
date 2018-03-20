package com.nespresso.exercise.piramid.layer.block;

import java.util.ArrayList;
import java.util.List;

public class BlocksFactory {
    private static final int SLAVES_PER_BLOCK = 50;

    public static Blocks createBlocks(int slaves, int anks) {
        int blockNumber = slaves / SLAVES_PER_BLOCK;
        int anksPerBlock = anks / blockNumber;
        if (anksPerBlock >= 2) {
            List<Block> highQualityBlocks = new ArrayList<>();
            for (int i = 0; i < blockNumber; i++) {
                highQualityBlocks.add(new HighQualityBlock());
            }
            return new Blocks(highQualityBlocks);
        } else {
            List<Block> lowQualityBlocks = new ArrayList<>();
            for (int i = 0; i < blockNumber; i++) {
                lowQualityBlocks.add(new LowQualityBlock());
            }
            return new Blocks(lowQualityBlocks);
        }
    }
}

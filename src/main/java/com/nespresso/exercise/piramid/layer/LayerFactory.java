package com.nespresso.exercise.piramid.layer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LayerFactory {
    private final static Pattern pattern = Pattern.compile("(\\d*) Slaves, (\\d*) Anks");

    static Layer createLayer(String s) {
        Matcher matcher = pattern.matcher(s);
        Layer newLayer = null;
        if (matcher.find()) {
            int slaves = Integer.parseInt(matcher.group(1));
            int anks = Integer.parseInt(matcher.group(2));
            newLayer = new Layer(slaves, anks);
        }
        return newLayer;
    }
}
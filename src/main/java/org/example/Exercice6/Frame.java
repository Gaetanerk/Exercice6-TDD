package org.example.Exercice6;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
    }

    public boolean makeRoll() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Please implement the makeRoll method");
    }
}
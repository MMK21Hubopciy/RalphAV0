package com.paladinzzz.game.util;
public class CurrentLevel {
    private int currentWorld;
    private int currentLevel;

    public CurrentLevel(int setWorld) {
        currentLevel = 1;
    }

    public void setCurrentWorld(int setWorld) {
        this.currentWorld = setWorld;
    }

    public void setCurrentLevel(int setLevel) {
        this.currentLevel = setLevel;
    }

    public void addLevel() {
        this.currentLevel += 1;
    }

    public int getCurrentWorld() {
        return currentWorld;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}

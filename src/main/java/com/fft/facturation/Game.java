package com.fft.facturation;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Frame> frames = new ArrayList<>();

    Integer extraRoll = 0;

    private int indexFrame = 0;

    private int score = 0;

    private boolean isGameFinished = false;

    public Game() {
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void roll (int pins) {
        if (indexFrame < 10) {
            Frame frameCourante = frames.get(indexFrame);
            frameCourante.editScore(pins);
            if (frameCourante.isTerminate()) {
                indexFrame++;
            }
        }
        if (indexFrame == 10 && (frames.get(9).isSpare() || frames.get(9).isStrike())) {
            extraRoll = pins;
        }
    }

    public int score () {
        calculateFramesBonus(frames);
        for (int i = 0; i < frames.size(); i++) {
            Frame f = frames.get(i);
            score += f.getScore() ;
        }
        return score + extraRoll;
    }

    private void calculateFramesBonus(List<Frame> frames) {
        for (int i = 0; i < frames.size(); i++) {
            Frame frameCourante = frames.get(i);
            if (frameCourante.isStrike() && i != 9) {
                Frame frameSuivante = frames.get(i + 1);
                frameCourante.setBonus(frameSuivante.getScore1() + frameSuivante.getScore2());
            } else if (frameCourante.isSpare() && i != 9) {
                Frame frameSuivante = frames.get(i + 1);
                frameCourante.setBonus(frameSuivante.getScore1());
            }
        }
    }
}

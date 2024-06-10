package com.fft.facturation;

public class Frame {
    private int score1 = 0;
    private int score2 = 0;
    private int bonus = 0;

    private boolean terminate = false;

    private boolean firstRoll = true;

    private boolean isStrike = false;

    private boolean isSpare = false;

    public int getScore() {
        return score1 + score2 + bonus;
    }

    public boolean isFirstRoll() {
        return firstRoll;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void editScore(int pins) {
        if (isFirstRoll()) {
            score1 = pins;
            firstRoll = false;
            if (pins == 10) {
                terminate = true;
            }
        } else {
            score2 = pins;
            terminate = true;
        }
        isStrikeOrSpare();
        //isFrameTerminate();
    }

    private void isFrameTerminate() {
        if (isStrike) {
            terminate = true;
        } else if (!isFirstRoll()) {

        }
    }

    private void isStrikeOrSpare() {
        if (score1 == 10) {
            isStrike = true;
        } else if (score1 + score2 == 10) {
            isSpare = true;
        }
    }
}

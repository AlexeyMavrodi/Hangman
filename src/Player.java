public class Player {
    private static final int MAXIMUM_COUNT_MISTAKES = 6;
    private int currentCountMistakes;
    private boolean isWin;

    public void incrementMistakes() {
        currentCountMistakes++;
    }

    public boolean isLoss() {
        return MAXIMUM_COUNT_MISTAKES == currentCountMistakes;
    }

    public int getCurrentCountMistakes() {
        return currentCountMistakes;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Scanner scanner;
    private Player player;
    private Word word;

    public void start() {
        scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();
        switch(choice) {
            case "1" -> newGame();
            case "2" -> { return; }
            default -> {
                ConsolePrinter.incorrectValue();
                start();
            }
        }
    }

    private void newGame() {
        player = new Player();

        try {
            word = new Word(RandomWordReader.getWord());
        } catch (IOException e) {
            System.err.println("Не удалось загрузить случайное слово. Используем слово по умолчанию.");
            word = new Word("исключение");
        }

        scanner = new Scanner(System.in);
        ConsolePrinter.startGame(word.getWord());

        while (!player.isLoss()) {
            if (!String.valueOf(word.getLettersWord()).contains("_")) {
                player.setWin(true);
                break;
            }

            ConsolePrinter.counterMistakes(player.getCurrentCountMistakes(), word.getLettersWord());
            String symbol = scanner.nextLine();

            if (symbol.length() > 1 || symbol.length() == 0) {
                ConsolePrinter.validationInputLength();
                continue;
            }

            if (!symbol.matches("[а-яА-Я]")) {
                ConsolePrinter.validationInputChar();
                continue;
            }

            char ch = symbol.toLowerCase().charAt(0);

            if (word.isContainsSet(ch)) {
                ConsolePrinter.validationInputRepeatChar();
                continue;
            }

            word.addSymbolToSet(ch);

            if (word.isLetterInWord(ch)) {
                ConsolePrinter.guessedLetter();
            } else {
                player.incrementMistakes();
                StateGallows state = StateGallows.values()[player.getCurrentCountMistakes() - 1];
                System.out.println(state.getState());
            }
        }

        if (player.isWin()) {
            ConsolePrinter.winGame(word.getWord());
        } else {
            ConsolePrinter.loseGame();
        }

        ConsolePrinter.againGame();
        start();
    }
}

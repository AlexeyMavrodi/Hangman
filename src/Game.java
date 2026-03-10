import RandomWordReader.RandomEnglishWordReader;
import RandomWordReader.RandomRussianWordReader;
import RandomWordReader.RandomWordReader;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Scanner scanner;
    private Player player;
    private Word word;
    private RandomWordReader reader;

    public void start() {
        scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();

        switch(choice) {
            case "1" -> {
                choiceLanguage();
                newGame();
            }
            case "2" -> { return; }
            default -> {
                ConsolePrinter.incorrectValue();
                start();
            }
        }
    }

    private void choiceLanguage() {
        ConsolePrinter.choiceLanguage();
        scanner = new Scanner(System.in);
        String choiceLanguage = scanner.nextLine().trim();

        switch(choiceLanguage) {
            case "1" -> reader = new RandomRussianWordReader();
            case "2" -> reader = new RandomEnglishWordReader();
            default -> {
                ConsolePrinter.incorrectValue();
                choiceLanguage();
            }
        }
    }

    private void newGame() {
        player = new Player();

        try {
            word = new Word(reader.getWord());
        } catch (IOException e) {
            System.err.println("Не удалось загрузить случайное слово. Используем русское слово по умолчанию.");
            reader = new RandomRussianWordReader();
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

            if (symbol.length() != 1) {
                ConsolePrinter.validationInputLength();
                continue;
            }

            if (reader instanceof RandomRussianWordReader && !symbol.matches("[а-яА-Я]")) {
                ConsolePrinter.validationInputRussianLetter();
                continue;
            }

            if (reader instanceof RandomEnglishWordReader && !symbol.matches("[a-zA-Z]")) {
                ConsolePrinter.validationInputEnglishLetter();
                continue;
            }

            char ch = symbol.toLowerCase().charAt(0);

            if (word.isContainsSet(ch)) {
                ConsolePrinter.validationInputRepeatLetter();
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
            ConsolePrinter.loseGame(word.getWord());
        }

        ConsolePrinter.againGame();
        start();
    }
}

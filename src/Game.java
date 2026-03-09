import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Scanner scanner;
    private Player player;
    private Word word;

    public void start() {
        System.out.println("Хотите сыграть? (введите цифру)\n1. Начать новую игру.\n2. Выйти из приложения.");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            case 1 -> newGame();
            case 2 -> { return; }
            default -> {
                System.out.println("Неверное значение. Попробуйте ещё раз!");
                start();
            }
        }
    }

    private void newGame() {
        player = new Player();

        try {
            word = new Word(RandomWordReader.getWord());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        scanner = new Scanner(System.in);
        System.out.println("Игра началась! Слово состоит из " + word.getWord().length() + " букв.\nВаша задача попытаться отгадать это слово имея 6 попыток.");

        while (!player.isLoss()) {
            if (!String.valueOf(word.getLettersWord()).contains("_")) {
                player.setWin(true);
                break;
            }

            System.out.println("Количество ошибок: " + player.getCurrentCountMistakes() + "\n" + String.valueOf(word.getLettersWord()) + "\nВведите букву: ");
            String symbol = scanner.nextLine();

            if (symbol.length() > 1 || symbol.length() == 0) {
                System.out.println("Введите одну букву!");
                continue;
            }

            char ch = symbol.toLowerCase().charAt(0);

            if (Character.isDigit(ch)) {
                System.out.println("Необходимо ввести букву!");
                continue;
            }

            if (word.isLetterInWord(ch)) {
                System.out.println("Такая буква есть в слове!");
            } else {
                player.incrementMistakes();
                StateGallows state = StateGallows.values()[player.getCurrentCountMistakes() - 1];
                System.out.println(state.getState());
            }
        }

        if (player.isWin()) {
            System.out.println("Вы отгадали слово!" + "\n" + word.getWord());
            start();
        } else {
            System.out.println("К сожалению вы проиграли.");
            start();
        }
    }
}

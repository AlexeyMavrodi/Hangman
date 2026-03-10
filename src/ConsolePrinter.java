public class ConsolePrinter {

    public static void welcome() {
        System.out.println("Добро пожаловать в игру ВИСЕЛИЦА!" +
                "\nХотите сыграть? (введите цифру)" +
                "\n1. Начать новую игру." +
                "\n2. Выйти из приложения.");
    }

    public static void againGame() {
        System.out.println("\nХотите сыграть ещё раз? (введите цифру)" +
                "\n1. Начать новую игру." +
                "\n2. Выйти из приложения.");
    }

    public static void startGame(String word) {
        System.out.println("Игра началась! Слово состоит из " + word.length() + " букв.\nВаша задача попытаться отгадать это слово имея 6 попыток.");
    }

    public static void incorrectValue() {
        System.out.println("Неверное значение. Попробуйте ещё раз!");
    }

    public static void loseGame() {
        System.out.println("К сожалению, вы проиграли.");
    }

    public static void winGame(String word) {
        System.out.println("Вы отгадали слово!" + "\n" + word);
    }

    public static void counterMistakes(int countMistakes, char[] lettersWord) {
        System.out.println("Количество ошибок: " + countMistakes + "\n" + String.valueOf(lettersWord) + "\nВведите букву: ");
    }

    public static void validationInputLength() {
        System.out.println("Введите одну букву!");
    }

    public static void validationInputChar() {
        System.out.println("Введите букву!");
    }

    public static void validationInputRepeatChar() {
        System.out.println("Вы уже вводили такую букву!");
    }

    public static void guessedLetter() {
        System.out.println("Такая буква есть в слове!");
    }
}

public class ConsolePrinter {

    public static void welcome() {
        System.out.println("""
                Добро пожаловать в игру ВИСЕЛИЦА!\
                
                Хотите сыграть? (введите цифру)\
                
                1. Начать новую игру.\
                
                2. Выйти из приложения.""");
    }

    public static void againGame() {
        System.out.println("""
                
                Хотите сыграть ещё раз? (введите цифру)\
                
                1. Начать новую игру.\
                
                2. Выйти из приложения.""");
    }

    public static void startGame(String word) {
        System.out.println("Игра началась! Слово состоит из " + word.length() + " букв.\nВаша задача попытаться отгадать это слово имея 6 попыток.");
    }

    public static void incorrectValue() {
        System.out.println("Неверное значение. Попробуйте ещё раз!");
    }

    public static void loseGame(String word) {
        System.out.println("К сожалению, вы проиграли.\nЗагаданное слово: " + word);
    }

    public static void winGame(String word) {
        System.out.println("Вы отгадали слово!\n" + word);
    }

    public static void counterMistakes(int countMistakes, char[] lettersWord) {
        System.out.println("Количество ошибок: " + countMistakes + "\n" + String.valueOf(lettersWord) + "\nВведите букву: ");
    }

    public static void validationInputLength() {
        System.out.println("Введите одну букву!");
    }

    public static void validationInputRussianLetter() {
        System.out.println("Введите русскую букву!");
    }

    public static void validationInputEnglishLetter() {
        System.out.println("Введите английскую букву!");
    }

    public static void validationInputRepeatLetter() {
        System.out.println("Вы уже вводили такую букву!");
    }

    public static void guessedLetter() {
        System.out.println("Такая буква есть в слове!");
    }

    public static void choiceLanguage() {
        System.out.println("Выберите язык, на котором будет слово:\n" +
                           "1. Русский\n" +
                           "2. Английский");
    }
}

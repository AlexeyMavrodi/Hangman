import java.util.Arrays;

public class Word {
    private final String word;
    private char[] lettersWord;

    public Word(String word) {
        this.word = word;
        this.lettersWord = new char[word.length()];
        Arrays.fill(this.lettersWord, '_');
    }

    public boolean isLetterInWord(char letter) {
        int index = word.indexOf(letter);
        boolean found = false;

        while (index != -1) {
            found = true;
            lettersWord[index] = letter;
            index = word.indexOf(letter, index + 1);
        }

        return found;
    }

    public String getWord() {
        return word;
    }

    public char[] getLettersWord() {
        return lettersWord;
    }
}

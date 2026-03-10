import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Word {
    private final String word;
    private char[] lettersWord;
    private Set<Character> inputChars;

    public Word(String word) {
        this.word = word;
        inputChars = new HashSet<>();
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

    public void addSymbolToSet(char ch) {
        inputChars.add(ch);
    }

    public boolean isContainsSet(char ch) {
        return inputChars.contains(ch);
    }

    public String getWord() {
        return word;
    }

    public char[] getLettersWord() {
        return lettersWord;
    }
}

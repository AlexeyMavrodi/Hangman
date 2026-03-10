package RandomWordReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RandomEnglishWordReader extends RandomWordReader {

    @Override
    public String getWord() throws IOException {
        List<String> words = Files.readAllLines(Path.of("resources", "english_nouns_words.txt"));
        int index = random.nextInt(words.size());
        return words.get(index).trim();
    }
}

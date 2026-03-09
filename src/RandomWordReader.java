import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class RandomWordReader {
    private static Path path = Path.of("src", "words.txt");
    private static Random random = new Random();

    public static String getWord() throws IOException {
        List<String> words = Files.readAllLines(path);
        int index = random.nextInt(words.size());
        return words.get(index).trim();
    }
}

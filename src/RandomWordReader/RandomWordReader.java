package RandomWordReader;

import java.io.IOException;
import java.util.Random;

public abstract class RandomWordReader {
    protected static Random random = new Random();

    public abstract String getWord() throws IOException;
}

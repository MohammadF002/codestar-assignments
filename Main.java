import src.InvertedIndex;
import src.UserInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();
        try {
            invertedIndex.createInvertedIndexFromFiles("EnglishData");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        UserInterface ui = new UserInterface();
        ui.run(invertedIndex);
    }
}

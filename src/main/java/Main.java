

import model.InvertedIndex;
import view.UserInterface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();
        try {
            invertedIndex.createInvertedIndexFromFiles("EnglishData");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserInterface ui = new UserInterface();
        ui.run(invertedIndex);
    }
}

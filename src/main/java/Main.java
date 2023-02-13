

import model.InvertedIndex;
import model.dataSource.FileSource;
import view.UserInterface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();
        invertedIndex.createInvertedIndexFromSource(new FileSource("EnglishData"));
        UserInterface ui = new UserInterface();
        ui.run(invertedIndex);
    }
}

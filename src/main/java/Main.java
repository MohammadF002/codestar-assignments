import model.InvertedIndex;
import model.crawler.BasicFileCrawler;
import model.dataSource.FileWordExtractor;
import view.UserInterface;

public class Main {
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();
        invertedIndex.createInvertedIndexFromSource(new BasicFileCrawler(), new FileWordExtractor(),
                "EnglishData");
        UserInterface ui = new UserInterface();
        ui.run(invertedIndex);
    }
}

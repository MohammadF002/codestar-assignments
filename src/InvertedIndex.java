package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InvertedIndex {
    private HashMap<String, Set<String>> invertedIndexMap;


    public void createInvertedIndexFromFiles(String targetLocation) throws FileNotFoundException {
        HashMap<String, Set<String>> map = new HashMap<>();
        FileHandler fileHandler = new FileHandler();
        List<File> files = fileHandler.gatherAllFiles(targetLocation);
        for (File file : files) {
            List<String> words = fileHandler.getWordsInFile(file);
            for (String word : words) {
                if (map.containsKey(word))
                    map.get(word).add(file.getName());
                else {
                    map.put(word, new HashSet<>());
                    map.get(word).add(file.getName());
                }
            }
        }
        this.invertedIndexMap = map;
    }
    public List<Set<String>> extractWordsFromInvertedIndex(Iterable<String> words) {
        List<Set<String>> result = new ArrayList<>();
        for (String word : words)
            result.add(this.invertedIndexMap.get(word));
        return result;
    }
}

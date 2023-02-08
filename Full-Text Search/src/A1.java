import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A1 {
    public static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
    static List<String> getWords(String fileLocation) throws FileNotFoundException {
        List<String> result = new ArrayList<>();
        File file = new File(fileLocation);
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNext()) {
            result.addAll(List.of(fileReader.nextLine().split(" ")));
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(System.in);
        Iterable<String> fileNames = listFilesUsingJavaIO("EnglishData");
        HashMap<String,List<String>> invertedIndex = new HashMap<>();
        for (String fileName : fileNames) {
            List<String> words = getWords("EnglishData\\"+fileName);
            for (String word : words) {
                if (!invertedIndex.containsKey(word)) {
                    invertedIndex.put(word,new ArrayList<>());
                    invertedIndex.get(word).add(fileName);
                    continue;
                }
                invertedIndex.get(word).add(fileName);
            }
        }

        while (true) {
            System.out.println("Enter word:");
            String word = myScanner.nextLine();
            for (String fileName : invertedIndex.get(word))
                System.out.println(fileName);
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A2 {
    public static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
    static Set<String> getWords(String fileLocation) throws FileNotFoundException {
        Set<String> result = new HashSet<>();
        File file = new File(fileLocation);
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNext())
            result.addAll(List.of(fileReader.nextLine().split(" ")));
        return result;
    }

    static Set<String> union(HashMap<String,Set<String>> invertedIndex, List<String> words) {
        Set<String> res = new HashSet<>();
        for (String word:words)
            res.addAll(invertedIndex.get(word));
        return res;
    }

    static Set<String> intersection(HashMap<String,Set<String>> invertedIndex, List<String> words) {
        Set<String> res = new HashSet<>(invertedIndex.get(words.get(0)));
        for (String word : words)
            res.retainAll(invertedIndex.get(word));
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(System.in);
        Iterable<String> fileNames = listFilesUsingJavaIO("EnglishData");
        HashMap<String,Set<String>> invertedIndex = new HashMap<>();
        for (String fileName : fileNames) {
            Set<String> words = getWords("EnglishData\\"+fileName);
            for (String word : words) {
                if (!invertedIndex.containsKey(word)) {
                    invertedIndex.put(word,new HashSet<>());
                    invertedIndex.get(word).add(fileName);
                    continue;
                }
                invertedIndex.get(word).add(fileName);
            }
        }

        while (true) {
            System.out.println("Enter word:");
            String input = myScanner.nextLine();
            String[] words = input.split(" ");
            List<String> unionWords = new ArrayList<>();
            List<String> subWords = new ArrayList<>();
            List<String> interWords = new ArrayList<>();
            for (String word:words) {
                if (word.startsWith("+"))
                    unionWords.add(word.substring(1));
                else if (word.startsWith("-"))
                    subWords.add(word.substring(1));
                else
                    interWords.add(word);
            }
            Set<String> unionFiles = union(invertedIndex, unionWords);
            Set<String> intersectFiles = intersection(invertedIndex,interWords);
            Set<String> subFiles = union(invertedIndex, subWords);
            unionFiles.retainAll(intersectFiles);
            unionFiles.removeAll(subFiles);
            for (String out:unionFiles)
                System.out.println(out);
        }
    }
}

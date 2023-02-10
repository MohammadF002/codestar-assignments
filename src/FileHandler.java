package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileHandler {
    public List<File> getAllFiles(String targetPath) {
        File folder = new File(targetPath);
        List<File> result = new ArrayList<>();
        for (File file : List.of(Objects.requireNonNull(folder.listFiles()))) {
            if (file.isFile())
                result.add(file);
        }
        return result;
    }

    public List<String> getWordsInFile (File targetFile) throws FileNotFoundException {
        Scanner fileReader = new Scanner(targetFile);
        List<String> result = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            String nextLine = fileReader.nextLine();
            result.addAll(List.of(nextLine.split(" ")));
        }
        return result;
    }
}

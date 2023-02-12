package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileHandler {
    public List<String> gatherAllFileNames(String targetPath) {
        File folder = new File(targetPath);
        return new ArrayList<>(List.of(Objects.requireNonNull(folder.list())));
    }

    public List<String> getWordsInFile (String fileLocation) throws IOException {
        String fileString = new String(Files.readAllBytes(Paths.get(fileLocation)));
        return List.of(fileString.split("\\s+"));
    }
}

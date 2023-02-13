package model.dataSource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWordExtractor implements SourceWordExtractor {

    @Override
    public List<String> fetchWordsFromSource(String sourceLocation) {
        String fileString;
        try {
            fileString = new String(Files.readAllBytes(Paths.get(sourceLocation)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return List.of(fileString.split("\\s+"));
    }


}
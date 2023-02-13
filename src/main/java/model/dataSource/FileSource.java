package model.dataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileSource implements DataSource {

    private final String targetLocation;
    private String sourceName;

    public FileSource(String targetLocation, String sourceName) {
        this.targetLocation = targetLocation;
        this.sourceName = sourceName;
    }
    public FileSource(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    @Override
    public List<DataSource> fetchSource() {
        File folder = new File(targetLocation);
        ArrayList<DataSource> res = new ArrayList<>();
        for (String fileName : List.of(Objects.requireNonNull(folder.list())))
            res.add(new FileSource(targetLocation + "\\" + fileName, fileName));
        return res;
    }

    @Override
    public List<String> fetchWordsFromSource() {
        String fileString;
        try {
            fileString = new String(Files.readAllBytes(Paths.get(targetLocation)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return List.of(fileString.split("\\s+"));
    }

    @Override
    public String getSourceName() {
        return this.sourceName;
    }

}
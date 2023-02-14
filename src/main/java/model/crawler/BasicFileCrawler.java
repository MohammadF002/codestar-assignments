package model.crawler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicFileCrawler implements Crawler{
    @Override
    public List<String> fetchDataLocations(String location) {
        File folder = new File(location);
        ArrayList<String> res = new ArrayList<>();
        for (String fileName : Objects.requireNonNull(folder.list())) {
            if (new File(location + "\\" + fileName).isFile())
                res.add(location + "\\" + fileName);
        }
        return res;
    }
}

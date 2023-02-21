package model.crawler;

import java.util.List;

public interface Crawler {
    List<String> fetchDataLocations(String location);
}

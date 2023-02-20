package model.dataSource;

import java.util.List;

public interface SourceWordExtractor {
    List<String> extractWordsFromSource(String sourceLocation);
}

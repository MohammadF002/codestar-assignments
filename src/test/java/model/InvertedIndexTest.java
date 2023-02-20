package model;

import model.crawler.Crawler;
import model.dataSource.FileWordExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class InvertedIndexTest {


    private final Crawler crawler = mock(Crawler.class);

    private final FileWordExtractor extractor = mock(FileWordExtractor.class);
    private InvertedIndex invertedIndex;

    @BeforeEach
    void setUp() {
        invertedIndex = new InvertedIndex();
    }

    @Test
    public void canCreateTheMap() {
        // given
        String location = "test location";
        given(crawler.fetchDataLocations(location)).willReturn(List.of("1", "2", "3"));
        given(extractor.extractWordsFromSource("1")).willReturn(List.of("roukia", "ichi", "inoue", "kouchiki", "roukia"));
        given(extractor.extractWordsFromSource("2")).willReturn(List.of("aizen", "inoue", "orihime", "ichi"));
        given(extractor.extractWordsFromSource("3")).willReturn(List.of("orihime", "roukia", "aizen", "ichi", "UraHara"));
        var expected = new HashMap<String, Set<String>>() {{
            put("ROUKIA", Set.of("1", "3"));
            put("ICHI", Set.of("1", "2", "3"));
            put("INOUE", Set.of("1", "2"));
            put("KOUCHIKI", Set.of("1"));
            put("AIZEN", Set.of("2", "3"));
            put("ORIHIME", Set.of("2", "3"));
            put("URAHARA", Set.of("3"));
        }};
        // when
        invertedIndex.createInvertedIndexFromSource(crawler, extractor, location);
        // then
        for (String key : invertedIndex.getInvertedIndexMap().keySet())
            assertEquals(expected.get(key), invertedIndex.getInvertedIndexMap().get(key));

    }

}

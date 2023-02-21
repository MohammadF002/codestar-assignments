package model.dataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWordExtractorTest {

    private FileWordExtractor underTest;

    @BeforeEach
    void setUp() {
        underTest = new FileWordExtractor();
    }

    @Test
    void canExtractWordsFromSource() {
        // given
        String location = "src\\test\\resources\\File Word Extractor Test\\hello.txt";
        var expected = List.of(
                "hello",
                "how",
                "are",
                "you",
                "welcome",
                "back"
        );
        // when
        var res = underTest.extractWordsFromSource(location);
        // then
        assertEquals(res, expected);
    }
}
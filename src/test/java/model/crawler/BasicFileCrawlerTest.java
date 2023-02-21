package model.crawler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasicFileCrawlerTest {

    private BasicFileCrawler underTest;

    @BeforeEach
    void setUp() {
        underTest = new BasicFileCrawler();
    }

    @Test
    void canFetchDataLocations() {
        // given
        String location = "src\\test\\resources\\Basic File Crawler Test";
        List<String> expected = List.of(
                "src\\test\\resources\\Basic File Crawler Test\\1354.txt",
                "src\\test\\resources\\Basic File Crawler Test\\helloWorld.txt",
                "src\\test\\resources\\Basic File Crawler Test\\M M M.txt"
        );

        // when
        var res = underTest.fetchDataLocations(location);

        // then
        assertEquals(res, expected);

    }
}
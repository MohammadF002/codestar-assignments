package model.crawler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveFileCrawlerTest {
    private RecursiveFileCrawler underTest;

    @BeforeEach
    void setUp() {
        underTest = new RecursiveFileCrawler();
    }

    @Test
    void canFetchDataLocations() {
        // given
        String location = "src\\test\\resources\\Recursive File Crawler Test";
        List<String> expected = List.of(
                "src\\test\\resources\\Recursive File Crawler Test\\1354.txt",
                "src\\test\\resources\\Recursive File Crawler Test\\folder\\helloWorld.txt",
                "src\\test\\resources\\Recursive File Crawler Test\\folder\\M M M.txt"
        );

        // when
        var res = underTest.fetchDataLocations(location);

        // then
        assertEquals(res, expected);
    }
}
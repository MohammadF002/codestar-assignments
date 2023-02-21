package model.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComplexQueryResponseGeneratorTest {

    private ComplexQueryResponseGenerator underTest;

    @BeforeEach
    void setUp() {
        underTest = new ComplexQueryResponseGenerator();
    }

    @Test
    void canGenerate() {
        // given
        var invertedIndexMap = new HashMap<String, Set<String>>() {{
            put("ROUKIA", Set.of("1", "3"));
            put("ICHI", Set.of("1", "2", "3"));
            put("INOUE", Set.of("1", "2"));
            put("KOUCHIKI", Set.of("1"));
            put("AIZEN", Set.of("2", "3"));
            put("ORIHIME", Set.of("2", "3"));
            put("URAHARA", Set.of("3"));
        }};
        List<String> including = List.of("AIZEN", "INOUE");
        List<String> excluding = List.of("URAHARA");
        List<String> intersection = List.of("ROUKIA", "ICHI");

        // when
        var res = underTest.generate(including, excluding, intersection, invertedIndexMap);

        // then
        assertEquals(res, Set.of("1"));

    }



}
package model.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComplexQueryDecoderTest {
        private ComplexQueryDecoder underTest;

    @BeforeEach
    void setUp() {
        underTest = new ComplexQueryDecoder();
    }

    @Test
    void canDecode() {
        // given

        String queryRequest = "get help +illness +disease -cough";
        var expected = new DecoderResponse(List.of(
                List.of("ILLNESS", "DISEASE"),
                List.of("COUGH"),
                List.of("GET", "HELP")
        ));

        // when

        var res = underTest.decode(queryRequest);

        // then
        assertEquals(res.getArgs().get(0), expected.getArgs().get(0));
        assertEquals(res.getArgs().get(1), expected.getArgs().get(1));
        assertEquals(res.getArgs().get(2), expected.getArgs().get(2));

    }
}
package model.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Getter
public class DecoderResponse {
    private final List<List<String>> args;
}

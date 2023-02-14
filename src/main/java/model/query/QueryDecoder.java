package model.query;

import java.util.HashMap;
import java.util.List;

public interface QueryDecoder {
    DecoderResponse decode(String queryRequest);
}

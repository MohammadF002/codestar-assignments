package model.query;


public interface QueryDecoder {
    DecoderResponse decode(String queryRequest);
}

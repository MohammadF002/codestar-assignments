package model.query;

import model.InvertedIndex;

import java.util.List;
import java.util.Set;

public class ComplexQuery implements Query {

    private final QueryResponseGenerator responseGenerator;
    private final InvertedIndex invertedIndex;
    private List<String> including;
    private List<String> excluding;
    private List<String> intersection;


    public ComplexQuery(String queryRequest, InvertedIndex invertedIndex, QueryDecoder decoder,
                        QueryResponseGenerator generator) {
        this.invertedIndex = invertedIndex;
        var decoderResponse = decoder.decode(queryRequest);
        setFiller(decoderResponse);
        responseGenerator = generator;
    }

    private void setFiller(DecoderResponse response) {
        this.including = response.getArgs().get(0);
        this.intersection = response.getArgs().get(2);
        this.excluding = response.getArgs().get(1);
    }


    @Override
    public Set<String> sendQueryResponse() {
        return this.responseGenerator.generate(including, excluding, intersection, invertedIndex.getInvertedIndexMap());
    }

}

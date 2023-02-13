package model.query;

import model.InvertedIndex;

import java.util.Set;

public class ComplexQuery implements Query {

    private final QueryResponseGenerator collector;
    private final InvertedIndex invertedIndex;
    private final Set<String> including;
    private final Set<String> excluding;
    private final Set<String> intersection;


    public ComplexQuery(String queryRequest, InvertedIndex invertedIndex) {
        this.invertedIndex = invertedIndex;
        QueryDecoder decoder = new ComplexQueryDecoder();
        var sets = decoder.decode(queryRequest);
        this.including = sets.get("including");
        this.excluding = sets.get("excluding");
        this.intersection = sets.get("intersection");
        collector = new ComplexQueryResponseGenerator();
    }


    @Override
    public Set<String> sendQueryResponse() {
        return this.collector.generate(including, excluding, intersection, invertedIndex.getMap());
    }

}

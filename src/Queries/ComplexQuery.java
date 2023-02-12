package src.Queries;

import src.InvertedIndex;

import java.util.Set;

public class ComplexQuery implements Query {
    private final String queryRequest;

    private final ComplexQueryCollector collector;
    private final InvertedIndex invertedIndex;
    private Set<String> including;
    private Set<String> excluding;
    private Set<String> intersection;


    public ComplexQuery(String queryRequest, InvertedIndex invertedIndex) {
        this.queryRequest = queryRequest;
        this.invertedIndex = invertedIndex;
        ComplexQueryDecoder decoder = new ComplexQueryDecoder();
        decoder.decode(this);
        collector = new ComplexQueryCollector();
    }


    @Override
    public Set<String> sendQueryResponse() {
        return this.collector.collect(including, excluding, intersection, invertedIndex);
    }

    public void setSets(Set<String> including, Set<String> excluding, Set<String> intersection) {
        this.including = including;
        this.excluding = excluding;
        this.intersection = intersection;
    }

    public String getQueryRequest() {
        return queryRequest;
    }
}

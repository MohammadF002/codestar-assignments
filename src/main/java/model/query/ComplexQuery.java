package model.query;

import model.InvertedIndex;

import java.util.HashMap;
import java.util.Set;

public class ComplexQuery implements Query {

    private final QueryResponseGenerator responseGenerator;
    private final InvertedIndex invertedIndex;
    private Set<String> including;
    private Set<String> excluding;
    private Set<String> intersection;


    public ComplexQuery(String queryRequest, InvertedIndex invertedIndex, QueryDecoder decoder) {
        this.invertedIndex = invertedIndex;
        var sets = decoder.decode(queryRequest);
        setFiller(sets);
        responseGenerator = new ComplexQueryResponseGenerator();
    }

    private void setFiller(HashMap<String, Set<String>> args) {
        this.including = args.get("including");
        this.intersection = args.get("intersection");
        this.excluding = args.get("excluding");
    }


    @Override
    public Set<String> sendQueryResponse() {
        return this.responseGenerator.generate(including, excluding, intersection, invertedIndex.getInvertedIndexMap());
    }

}

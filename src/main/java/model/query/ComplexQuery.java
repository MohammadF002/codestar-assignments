package model.query;

import model.InvertedIndex;

import java.util.HashMap;
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
        var sets = decoder.decode(queryRequest);
        setFiller(sets);
        responseGenerator = generator;
    }

    private void setFiller(HashMap<String, List<String>> args) {
        this.including = args.get("including");
        this.intersection = args.get("intersection");
        this.excluding = args.get("excluding");
    }


    @Override
    public Set<String> sendQueryResponse() {
        return this.responseGenerator.generate(including, excluding, intersection, invertedIndex.getInvertedIndexMap());
    }

}

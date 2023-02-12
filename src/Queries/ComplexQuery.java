package src.Queries;

public class ComplexQuery implements Query {
    private String queryRequest;


    public ComplexQuery(String queryRequest) {
        this.queryRequest = queryRequest;
        decoder();
    }


    @Override
    public String[] sendQueryResponse() {
        return new String[0];
    }
}

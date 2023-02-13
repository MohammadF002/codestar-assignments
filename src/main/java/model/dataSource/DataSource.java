package model.dataSource;

import java.util.List;

public interface DataSource {
    public List<DataSource> fetchSource();
    public List<String> fetchWordsFromSource();
    public String getSourceName();
}

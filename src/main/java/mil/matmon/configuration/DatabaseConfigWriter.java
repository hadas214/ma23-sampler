package mil.matmon.configuration;

import mil.matmon.configuration.database.Database;

import java.io.IOException;
import java.util.List;

public interface DatabaseConfigWriter {
    public void writer(List<Database> databaseList) throws IOException;
}

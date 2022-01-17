package mil.matmon.configuration;

import mil.matmon.configuration.database.Database;
import java.util.List;

public interface DatabaseConfigParser {

    public List<Database> parser(String name);
}

package mil.matmon.configuration;

import mil.matmon.configuration.database.Database;
import mil.matmon.json.WriteFileConfig;
import mil.matmon.csv.CsvParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    public static final String FILE_NAME = "src/main/resources/MadaReports.csv";
    public final ReaderFileConfig READER_FILE_CONFIG;
    public final CsvParser CSV_PARSER;
    private List<Database> objects;

    public DatabaseManager() {
        this.READER_FILE_CONFIG = new ReaderFileConfig(FILE_NAME);
        System.out.println("Connection was good");
        this.CSV_PARSER = new CsvParser();
        this.objects = new ArrayList<>();
    }

    public String propertyAsString() throws IOException {
        String property;
        property = this.READER_FILE_CONFIG.readFromInputStream();
        System.out.println("Read well the property");
        return property;
    }

    public void convertStringToObject() throws IOException {
        this.objects = this.CSV_PARSER.parser(this.propertyAsString());
        System.out.println("Done convert string to objects");
    }
    public void writeToJson()
    {
        WriteFileConfig w = new WriteFileConfig(this.objects);
        try {
            w.writer();
            System.out.println("Successfully written");
        }
        catch (Exception e)
        {
            System.out.println("Can't write to file");
        }
    }

    public static void main(String[] args) throws IOException {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.convertStringToObject();
        databaseManager.writeToJson();
    }
}

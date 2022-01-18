package mil.matmon.configuration;

import com.google.common.io.Files;
import mil.matmon.configuration.database.Database;
import mil.matmon.json.WriteFileConfig;
import mil.matmon.csv.CsvParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
    public static final String FILE_NAME = "src/main/resources/MadaReports.csv";
    public static final String CONVERT_TO = "json";
    public final Map<String, DatabaseConfigParser> allKindsFilesToParse;
    public final Map<String, DatabaseConfigWriter> allKindsFilesToWrite;
    public final ReaderFileConfig READER_FILE_CONFIG;
    private List<Database> objects;

    public DatabaseManager() {
        this.READER_FILE_CONFIG = new ReaderFileConfig(FILE_NAME);
        System.out.println("Connection was good");
        this.allKindsFilesToParse = new HashMap<>();
        this.allKindsFilesToWrite = new HashMap<>();
        this.objects = new ArrayList<>();
        //Boot maps with optional values
        this.bootSettings();
    }

    public String propertyAsString() throws IOException {
        String property;
        property = this.READER_FILE_CONFIG.readFromInputStream();
        System.out.println("Read well the property");
        return property;
    }
    public void bootSettings(){
        //Add here your classes
        this.allKindsFilesToParse.put("csv", new CsvParser());
        this.allKindsFilesToWrite.put("json", new WriteFileConfig());
    }

    public void convertStringToObject() {
        try {
            String extension = Files.getFileExtension(FILE_NAME);
            this.objects = this.allKindsFilesToParse.get(extension).parser(this.propertyAsString());
            System.out.println("Done convert string to objects");
        }
        catch (IOException e)
        {
            System.out.println("Can't convert string to list objects");
        }
    }
    public void writeToJson()
    {
        try {
            this.allKindsFilesToWrite.get(CONVERT_TO).writer(this.objects);
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

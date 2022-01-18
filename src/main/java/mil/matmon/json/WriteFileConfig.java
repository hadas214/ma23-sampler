package mil.matmon.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import mil.matmon.configuration.DatabaseConfigWriter;
import mil.matmon.configuration.database.Database;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteFileConfig implements DatabaseConfigWriter {
    public static final String DIRECTORY_NAME = "C:\\ma23\\TheConstantSampler\\mada_reports\\";
    public static final String ENDING_FILE = ".json";
    private ObjectMapper objectMapper;

    public WriteFileConfig()
    {
        this.objectMapper = new ObjectMapper();
    }

    public void writer(List<Database> databaseList) throws IOException {
        int lines = 1;
        String fileName = DIRECTORY_NAME + "mada_file_1" + ENDING_FILE;
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));

        for (int i= 0;  i < databaseList.size(); i ++) {;
            if (lines % 50000 == 0)
            {
                writer.close();
                fileName = DIRECTORY_NAME + "mada_file_" + Integer.toString(lines/50000 + 1) + ENDING_FILE;
                writer = Files.newBufferedWriter(Paths.get(fileName));
            }
            try {
                // Serialize Java object info JSON file.
                JsonObject database = new JsonObject();
                database.put("Report", databaseList.get(i).toString());
                // write JSON to file
                Jsoner.serialize(database, writer);
                lines++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

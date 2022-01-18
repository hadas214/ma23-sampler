package mil.matmon.csv;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import mil.matmon.configuration.DatabaseConfigParser;
import mil.matmon.configuration.database.Database;
import mil.matmon.configuration.database.TheConstantSampler;


import java.io.IOException;
import java.util.*;

public class CsvParser implements DatabaseConfigParser {
    private CsvMapper objectMapper;
    private List<Database> objects;

    public CsvParser()
    {
        this.objectMapper = new CsvMapper();
        this.objects = new ArrayList<>();
    }

    @Override
    public List<Database> parser(String config) throws IOException {
        List<Database> databaseList = new ArrayList<>();
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        ObjectReader mapper = this.objectMapper.reader(Map.class).with(csvSchema);


        try {
            MappingIterator<Map<String, Object>> iter = null;
            iter = mapper.readValues(config);
            Map<String, Object> info = null;


            while (iter.hasNext()) {
                info = iter.next();
                String[] arr = new String[info.size()];
//                databaseList = this.objectMapper.readValue(info.values().toString(), new TypeReference<List<Database>>() {
//               });
                int i = 0;
                for (Object o: info.keySet()) {
                    arr[i] = info.get(o).toString();
                    i++;
                }
                TheConstantSampler t = new TheConstantSampler(arr[0],arr[1], arr[2],arr[3],arr[4],arr[5],arr[6]
                        ,arr[7],arr[8],arr[9],arr[10],arr[11]);
                this.objects.add(t);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return this.objects;
    }
}

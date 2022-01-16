package mil.matmon.configuration;

import java.io.*;
import java.util.Properties;

public class ReaderFileConfig {
    public static final String FILE_NAME = "src/main/resources/MadaReports.csv";

    public static InputStream inputStream() throws IOException{
        InputStream iStream = null;
        try {
            // Loading properties file from the classpath
            iStream = new FileInputStream(FILE_NAME);
            if(iStream == null){
                throw new IOException("File not found");
            }
        } catch (IOException e) {
            throw new IOException("File not found");
        }
        return iStream;
    }
    public String readFromInputStream () throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        ReaderFileConfig r = new ReaderFileConfig();
        System.out.println(r.readFromInputStream());
    }
}

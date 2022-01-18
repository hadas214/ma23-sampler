package mil.matmon.configuration;

import java.io.*;

public class ReaderFileConfig {
    public String FILE_NAME;

    public ReaderFileConfig(String FILE_NAME)
    {
        this.FILE_NAME = FILE_NAME;
    }

    public InputStream inputStream() throws IOException{
        InputStream iStream = null;
        try {
            // Loading properties file from the classpath
            iStream = new FileInputStream(this.FILE_NAME);
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
}

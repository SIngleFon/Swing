package Client_Server.Server.Log;

import java.io.FileReader;
import java.io.FileWriter;

public class FileLogger implements Logger<String> {
    private static final String LOG_PATH = "src/Client_Server/Server/Log/log.txt";

    @Override
    public void appendLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            if (!(stringBuilder.isEmpty())){
                stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            }
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}


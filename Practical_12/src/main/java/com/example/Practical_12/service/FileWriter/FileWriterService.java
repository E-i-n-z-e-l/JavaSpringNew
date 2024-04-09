package com.example.Practical_12.service.FileWriter;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
@Data
@Service
public class FileWriterService {
    private final String fileName = "requests.txt";

    /**
     * Метод записи данных в файл.
     * @param request
     */
    public void writeToFile(String request) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(request + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

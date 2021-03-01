package service;

import au.com.bytecode.opencsv.CSVReader;
import entity.Task;
import service.reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final Reader reader;

    private static final String path = "C:\\study\\homework\\1lesson\\spring\\src\\main\\resources\\question.csv";

    public Service(Reader reader) {
        this.reader = reader;
    }

    public List<Task> getAllTask() {

        List<Task> list = new ArrayList<>();
        try {
            String[] nextLine;
            CSVReader read = reader.getReader(path);
            while ((nextLine = read.readNext()) != null) {
                Task task = new Task();
                if (nextLine != null) {
                    task.setQuestion(nextLine[0]);
                    task.setAnswer(nextLine[1]);
                }
                list.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Task getByLine(int line) {
        return null;
    }
}

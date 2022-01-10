package service;

import au.com.bytecode.opencsv.CSVReader;
import entity.Task;
import service.reader.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    private final Reader reader;

    private String path;

    public Service(Reader reader) {
        this.reader = reader;
    }

    public List<Task> getAllTasks() {
        CSVReader read;
        String[] nextLine;
        List<Task> list = new ArrayList<>();

        if ((read = getCSVReader()) == null){
            return Collections.emptyList();
        }

        try {
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

    private CSVReader getCSVReader() {
        CSVReader result = null;
        path = Service.class.getClassLoader().getResource("question.csv").getPath();
        try {
            result = reader.getReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}

package ru.otus.spring.service.utils.reader;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ReaderImpl implements Reader {

    public CSVReader getReader(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path.toString()), ';');
        return reader;
    }
}

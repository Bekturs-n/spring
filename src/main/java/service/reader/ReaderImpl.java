package service.reader;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class ReaderImpl implements Reader {

    public CSVReader getReader(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path), ';');
        return reader;
    }
}

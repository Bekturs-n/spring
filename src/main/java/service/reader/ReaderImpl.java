package service.reader;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class ReaderImpl implements Reader {

    public CSVReader getReader(Path path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path.toString()), ';');
        return reader;
    }
}

package service.reader;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.nio.file.Path;

public interface Reader {

    CSVReader getReader(String path) throws IOException;
}

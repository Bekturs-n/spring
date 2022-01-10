package service;

import au.com.bytecode.opencsv.CSVReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.reader.Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    private Reader reader;
    private CSVReader csvReader;

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service(reader);
        try {
            csvReader = new CSVReader(new FileReader(ServiceTest.class.getClassLoader().getResource("question.csv").getPath()), ';');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllTask() throws IOException {
        when(reader.getReader(anyString())).thenReturn(csvReader);
//        doReturn(csvReader).when(reader).getReader(anyString());
        assertEquals(service.getAllTasks().get(0).getQuestion(), "Какое слово всегда звучит неверно?");
    }
}
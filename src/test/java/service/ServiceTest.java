package service;

import entity.Task;
import org.junit.jupiter.api.Test;
import service.reader.ReaderImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

    ReaderImpl reader = new ReaderImpl();
    Service service;

    @Test
    void getAllTask() {
        service = new Service(reader);
        List<Task> list = service.getAllTask();
        Task t = list.get(0);
        assertEquals(t.getQuestion(), "Какое слово всегда звучит неверно?");
    }
}
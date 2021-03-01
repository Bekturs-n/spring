package service;

import entity.Task;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;
import service.reader.ReaderImpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

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
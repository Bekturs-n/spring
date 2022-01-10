package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.service.TaskService;
import ru.otus.spring.service.TestService;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TaskService service = context.getBean(TaskService.class);
        TestService test = context.getBean(TestService.class);
        test.test(service.getAllTasks());
    }
}

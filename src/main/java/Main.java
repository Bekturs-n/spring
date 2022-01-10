import entity.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Service;
import service.testLogic.Test;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Service service = context.getBean(Service.class);
        Test test = context.getBean(Test.class);
        test.test(service.getAllTask());
//        List<Task> tasks = service.getAllTask();

    }
}

import entity.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Service;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Service service = context.getBean(Service.class);
        List<Task> tasks = service.getAllTask();
        if (tasks != null) {
            for (Task t : service.getAllTask()) {
                System.out.println("Question - " + t.getQuestion());
                System.out.println("Answer for this question is " + t.getAnswer() + "\n");
            }
        }
    }
}

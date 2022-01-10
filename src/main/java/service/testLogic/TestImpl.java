package service.testLogic;

import entity.Task;

import java.util.List;
import java.util.Scanner;

public class TestImpl implements Test {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void test(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("В базе нет тестов");
            return;
        }
        for (Task t : tasks) {
            System.out.println("Question - " + t.getQuestion());
            String answer = answer();
            System.out.println(t.getAnswer().trim().equalsIgnoreCase(answer) ?
                    "Correct" : " Wrong, correct answer is " + t.getAnswer());
        }
    }

    protected String answer(){
        return scanner.next();
    }
}

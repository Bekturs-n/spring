package service.testLogic;

import entity.Task;

import java.util.List;
import java.util.Scanner;

public class TestImpl implements Test {

    @Override
    public void test(List<Task> tasks) {
        Scanner sc = new Scanner(System.in);
        if (tasks.isEmpty()) {
            System.out.println("В базе нет тестов");
            return;
        }
        for (Task t : tasks) {
            System.out.println("Question - " + t.getQuestion());
            String answer = sc.next();
            System.out.println(t.getAnswer().trim().equalsIgnoreCase(answer) ?
                    "Correct" : " Wrong, correct answer is " + t.getAnswer());
        }
    }
}

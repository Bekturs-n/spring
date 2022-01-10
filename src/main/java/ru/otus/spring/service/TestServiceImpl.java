package ru.otus.spring.service;

import ru.otus.spring.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class TestServiceImpl implements TestService {

    private String studentsName;
    private int studentsPoint;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void test(List<Task> tasks) {
        studentsPoint = 0;
        if (tasks.isEmpty()) {
            System.out.println("В базе нет тестов");
            return;
        }
        askStudentName();
        for (Task task : tasks) {
            System.out.println("Question - " + task.getQuestion());
            if (task.getAnswer().trim().equalsIgnoreCase(answer())) {
                studentsPoint++;
            }
        }
        showStudentResults();
    }

    private void showStudentResults() {
        System.out.println("Student - " + studentsName);
        System.out.println("Rating - " + studentsPoint);
    }

    protected void askStudentName() {
        System.out.println("What is your name?");
        studentsName = scanner.nextLine();
    }

    protected String answer() {
        return scanner.nextLine();
    }

    private void checkAnswer(Task task, String answer) {
        if (task.getAnswer().trim().equalsIgnoreCase(answer)) {
            studentsPoint++;
        }
    }
}

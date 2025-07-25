package org.example.chapter14;

//  == 성적 계산 프로그램 ==

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

class Student {
    private String name;
    private int score;

}

//인터페이스 - 성적 계산기
interface Grading {
    String calculateGrade(Student student);
}

public class C_Anonymous {
    public static void main(String[] args) {
        Student student1 = new Student("불멍이", 60);
        Student student2 = new Student("전기돌이", 95);
        Student student3 = new Student("바람둥이", 80);
        Student student4 = new Student("물렁이", 85);
        Student student5 = new Student("독덩이", 70);

        Student[] students = { student1, student2, student3, student4, student5 };

        Grading grading = new Grading() {
            @Override
            public String calculateGrade(Student student) {

                int score = student.getScore();

                if (score > 100 || score < 0) {
                    System.out.println("잘못된 점수 입니다.");
                    return null;
                } else if (score >= 90) {
                    return "A";
                } else if (score >= 80) {
                    return "B";
                } else if (score >= 70) {
                    return "C";
                } else if (score >= 60) {
                    return "D";
                } else {
                    return "F";
                }
            }
        };

        for (Student s : students) {
            String grade = grading.calculateGrade(s);

            if (grade != null) {
                System.out.println(s.getName() + "의 성적: " + grade);
            }
        }
    }
}

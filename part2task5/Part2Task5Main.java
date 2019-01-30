package org.test.epamtasks.part2task5;

import java.util.List;

public class Part2Task5Main {
    public static void main(String[] args) {

        Student st1 = new Student("Ivan", "Ivanov", "0001");
        Student st2 = new Student("Petr", "Petrov", "0002");
        Student st3 = new Student("Fedr", "Fedorov", "0003");

        CourseGradeList<Integer> eng = new CourseGradeList<>(Course.DISCIPLINE1);
        eng.addStudentAndGrade(st1, 5);
        eng.addStudentAndGrade(st2, 4);
        eng.addStudentAndGrade(st3, 3);
        System.out.println(eng.getFullInfo());

        System.out.println();
        List<StudentCourseGrade> testList = eng.ratingList();
        for (StudentCourseGrade student : testList) {
            System.out.println(student.getFullInfo());
        }

        System.out.println();


        CourseGradeList java = new CourseGradeList(Course.DISCIPLINE2);
        java.addStudentAndGrade(st2, 11.9);
        java.addStudentAndGrade(st3, 11);

        System.out.println(java.getFullInfo());

        List<StudentCourseGrade> testJava = java.ratingList();
        System.out.println();

        for (StudentCourseGrade student : testJava) {
            System.out.println(student.getFullInfo());
        }

        System.out.println();


        CourseGradeList math = new CourseGradeList(Course.DISCIPLINE3);

        System.out.println(math.getFullInfo());

        List<StudentCourseGrade> testMath = math.ratingList();
        System.out.println();

        for (StudentCourseGrade student : testMath) {
            System.out.println(student.getFullInfo());
        }

        System.out.println();

        AllCoursesLists testAll = new AllCoursesLists();
        testAll.addCourseGradeList(java);
        testAll.addCourseGradeList(eng);
        testAll.addCourseGradeList(math);

        List<String> st2CourseAndGrades = testAll.findStudentCoursesAndGrades(st2);
        for (String s : st2CourseAndGrades) {
            System.out.println(s);
        }

    }
}

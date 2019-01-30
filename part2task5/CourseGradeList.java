package org.test.epamtasks.part2task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseGradeList<T extends Number> {
    private Course course;
    private HashMap<Student, T> gradeList;

    public CourseGradeList(Course course) {
        this.course = course;
        this.gradeList = new HashMap<>();
    }

    public HashMap<Student, T> getGradeList() {
        return gradeList;
    }

    void addStudentAndGrade(Student student, T grade) {
        if (course.integerTypeOfGrades) {
            Integer gradeI = grade.intValue();
            gradeList.put(student, (T) gradeI);
        } else {
            Double gradeD = grade.doubleValue();
            gradeList.put(student, (T) gradeD);
        }
    }

    String getFullInfo() {
        StringBuilder str = new StringBuilder(course.getFullInfo());
        for(Student student: gradeList.keySet()) {
            str.append("\n");
            str.append(student.getFullInfo());
            str.append("  mark: " + gradeList.get(student));
        }
        return str.toString();
    }

    List<StudentCourseGrade> ratingList() {
        List<StudentCourseGrade> sortedList = new ArrayList<>();
        for (Student student: gradeList.keySet()) {
          sortedList.add(new StudentCourseGrade(student, gradeList.get(student), course));
        }
        sortedList.sort(StudentCourseGrade::compareTo);
        return sortedList;
    }

    StudentCourseGrade findStudentInfo(Student student) {
        return new StudentCourseGrade(student, gradeList.get(student), course);
    }



}



package org.test.epamtasks.part2task5;

public class StudentCourseGrade<T extends Number> {
    private Student student;
    private T grade;
    private Course course;

    StudentCourseGrade(Student student, T grade, Course course) {
        this.student = student;
        this.grade = grade;
        this.course = course;
    }

    public int compareTo(StudentCourseGrade studentForSort) {
        if (Math.abs(this.grade.doubleValue() - studentForSort.grade.doubleValue()) < 0.001) {
            return 0;
        }
        if (this.grade.doubleValue() < studentForSort.grade.doubleValue()) {
            return 1;
        } else {
            return -1;
        }
    }

    String getFullInfo() {
        return course.name + ", " + student.getFullInfo() + ", grade: " + grade;
    }
}

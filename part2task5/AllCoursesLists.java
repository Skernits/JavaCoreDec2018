package org.test.epamtasks.part2task5;

import java.util.ArrayList;
import java.util.List;

public class AllCoursesLists {
     List<CourseGradeList> allCourses;

    public AllCoursesLists() {
        this.allCourses = new ArrayList<>();
    }

    void addCourseGradeList(CourseGradeList list) {
        allCourses.add(list);
    }

    List<String> findStudentCoursesAndGrades(Student student) {
        List<String> result = new ArrayList<>();
        for (CourseGradeList list : allCourses) {
            if (list.getGradeList().containsKey(student)) {
                result.add(list.findStudentInfo(student).getFullInfo());
            }
        }
        return result;
    }
}

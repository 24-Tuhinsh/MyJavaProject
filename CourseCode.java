package edu.ccrm.domain;

import java.util.Objects;

public class CourseCode {
    private final String departmentCode;
    private final int courseNumber;
    
    public CourseCode(String departmentCode, int courseNumber) {
        this.departmentCode = Objects.requireNonNull(departmentCode, "Department code cannot be null");
        this.courseNumber = courseNumber;
    }
    
    public String getDepartmentCode() { return departmentCode; }
    public int getCourseNumber() { return courseNumber; }
    
    @Override
    public String toString() { return departmentCode + "-" + courseNumber; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCode that = (CourseCode) o;
        return courseNumber == that.courseNumber && Objects.equals(departmentCode, that.departmentCode);
    }
    
    @Override
    public int hashCode() { return Objects.hash(departmentCode, courseNumber); }
}
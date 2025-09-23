package edu.ccrm;

// Import necessary classes
import edu.ccrm.domain.CourseCode;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester; // Assuming Semester is an enum

public class Main {
    public static void main(String[] args) {
        // Create instructor
        Instructor profSmith = new Instructor("PROF001", "John", "Smith");

        // Create course using builder pattern
        // Note: The builder constructor now takes required parameters directly.
        CourseCode mathCourse = new CourseCode.Builder(
                "MATH",       // departmentCode
                101,          // courseNumber
                "Introduction to Calculus", // title
                3             // credits
            )
            .department("Mathematics")
            .semester(Semester.FALL)
            .instructor(profSmith)
            .description("Basic calculus concepts and applications")
            .maxEnrollment(25)
            // .currentEnrollment(0) // Optional: defaults to 0 if not set
            .build();

        // Test the course
        System.out.println("Course: " + mathCourse.getTitle());
        // Use get() on Optional and handle potential absence
        System.out.println("Instructor: " + mathCourse.getInstructor().map(Instructor::getFullName).orElse("N/A"));
        System.out.println("Credits: " + mathCourse.getCredits());
        System.out.println("Can enroll: " + mathCourse.canEnroll());
        System.out.println("Enrollment percentage: " + String.format("%.2f", mathCourse.getEnrollmentPercentage()) + "%");

        // Test enrollment
        try {
            mathCourse.incrementEnrollment();
            System.out.println("Enrolled one student. Current enrollment: " + mathCourse.getCurrentEnrollment());
            System.out.println("Enrollment percentage: " + String.format("%.2f", mathCourse.getEnrollmentPercentage()) + "%");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example of trying to enroll when full (if maxEnrollment was 1)
        // try {
        //     System.out.println("\nAttempting to enroll to full capacity:");
        //     CourseCode testCourseFull = new CourseCode.Builder("TEST", 100, "Full Course", 3)
        //                                     .maxEnrollment(1)
        //                                     .currentEnrollment(1)
        //                                     .build();
        //     testCourseFull.incrementEnrollment(); // This should throw an exception
        // } catch (Exception e) {
        //     System.out.println("Caught expected error: " + e.getMessage());
        // }
    }
}
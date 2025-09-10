package com.bridgelabz.oops.inheritance;

// Base class
class Course {
    protected String courseName;
    protected int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Fee after Discount: $" + getDiscountedFee());
    }
}

// Main class
public class CourseManagement {
    public static void main(String[] args) {
        PaidOnlineCourse course1 = new PaidOnlineCourse("Java Programming", 40, "Udemy", true, 200.0, 20.0);
        PaidOnlineCourse course2 = new PaidOnlineCourse("Python Data Science", 50, "Coursera", false, 250.0, 15.0);

        course1.displayCourseInfo();
        System.out.println();
        course2.displayCourseInfo();
    }
}

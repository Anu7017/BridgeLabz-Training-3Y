package com.bridgelabz.oops.inheritance;

// Superclass
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // Call to superclass constructor
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Display Book details
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class
public class LibraryManagement {
    public static void main(String[] args) {
        Author author1 = new Author("Java Programming", 2020, "James Gosling", "Father of Java.");
        Author author2 = new Author("Clean Code", 2008, "Robert C. Martin", "Known as Uncle Bob, software engineering expert.");

        author1.displayInfo();
        System.out.println();
        author2.displayInfo();
    }
}

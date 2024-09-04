package libraryManagement;

import java.util.Scanner;

class Book{
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    void borrowBook(){
        if (isAvailable){
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        }
        else {
            System.out.println(title + " is not available.");
        }
    }

    void returnBook(){
        isAvailable = true;
        System.out.println(title + " has been returned" );
    }

    void displayBookdetails(){
        System.out.println("Title : " + title + ", Author : "+ author + ", ISBN : " + isbn + ", Available : " + isAvailable);
    }
}

class Member{
    String name;

    Member(String name){
        this.name = name;
    }

    void displayMemberdetails(){
        System.out.println("Member name : " + name);
    }

    void borrowBook(Book book){
        book.borrowBook();
    }

    void returnBook(Book book){
        book.returnBook();
    }
}

class Library{
    Book[] books;
    Member[] members;
    int bookCount;
    int memberCount;

    Library(int bookSize, int memberSize){
        books = new Book[bookSize];
        members = new Member[memberSize];
        bookCount = 0;
        memberCount = 0;
    }

    void addBook(Book book){
        books[bookCount] = book;
        bookCount++;
        System.out.println(book.title + " has been added.");
    }

    void addMember( Member member){
        members[memberCount] = member;
        memberCount++;
        System.out.println("Membe "+ member.name + " has been added.");
    }

    void showAvailablebook(){
        System.out.println("Available books : ");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable) {
                System.out.println(books[i].title + " by " +books[i].author);
            }
        }
    }

    void  findBookbyISBN(String isbn){
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isbn.equals(isbn)){
                books[i].displayBookdetails();
                return;
            }
        }
        System.out.println("Books= with ISBN " + isbn + " not found.");
    }

    void showMembers(){
        System.out.println("Library Members : ");
        for (int i = 0; i < memberCount; i++) {
            members[i].displayMemberdetails();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(5,5);
        library.addBook(new Book("The Great Gutsy","XYZ","152565165"));
        library.addBook(new Book("HTHTHT","jhshsh","545654"));
        library.addBook(new Book("sudyf","f","3254"));
        library.addBook(new Book("sikf","kg","26584"));
        library.addBook(new Book("akeig","fr","36974"));

        while (true){
            System.out.println("\nLibrary Management System : ");
            System.out.println("1. Add Member");
            System.out.println("2. Show Member");
            System.out.println("3. Find book by ISBN");
            System.out.println("4. Show Available books");
            System.out.println("5. Exit");
            System.out.println("Choose any option");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 :
                    System.out.println("Enter member name : ");
                    String memberName = scanner.nextLine();
                    library.addMember(new Member(memberName));
                    break;
                case 2 :
                    library.showMembers();
                    break;
                case 3 :
                    System.out.println("Enter ISBN : ");
                    String isbn = scanner.nextLine();
                    library.findBookbyISBN(isbn);
                    break;
                case 4:
                    library.showAvailablebook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Good Job. ");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    // The fields.
    private String author, title, refNumber;
    private int pages, borrowed;
    final boolean courseText;
    private boolean isBorrowed;
    
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages, boolean bookCourseText)
    {
        author = bookAuthor;
        title = bookTitle;
        refNumber = "";
        pages = bookPages;
        borrowed = 0;
        courseText = bookCourseText;
        isBorrowed = false;
    }

    // Add the methods here ...
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getTitle()
    {
        return title;
    }

    public int getPages()
    {
        return pages;
    }
    
    public void printAuthor()
    {
        System.out.println("The book's author is " + author);
    }
    
    public void printTitle()
    {
        System.out.println("The book's title is " + title);
    }
    
    public void printDetails()
    {
        printTitle();
        printAuthor();
                System.out.println("This book has " + pages + " pages.");
        if (refNumber.length() > 0) {
            System.out.println("The book's reference number is " + refNumber);
        }
        else {
            System.out.println("The book has no reference number, please set it now.");
        }
        System.out.println("The book has been borrowed" + borrowed + " times.");
        
        
    }
    
    public void setrefNumber(String newrefNumber)
    {
        if (newrefNumber.length() >= 3) {
            refNumber = newrefNumber;
        }
        else {
            System.out.println("The reference number needs to be 3 characters or longer");
        }
    }
    
    public String getrefNumber()
    {
        return refNumber;
    }
    
    public int length(String refNumber)
    {
        refNumber.length();
        return refNumber.length();
    }
    
    public void borrowBook()
    {
        if (isBorrowed != true) {
            System.out.println("You are now borrowing " + author +"'s book " + title);
            borrowed++;
            isBorrowed = true;
        }
        else {
            System.out.println("Thanks for returning the book");
            isBorrowed = false;
        }
    }
    
    public int getBorrowed()
    {
        return borrowed;
    }
}
    

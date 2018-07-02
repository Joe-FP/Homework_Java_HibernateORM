import db.DBAuthor;
import db.DBBook;
import models.Author;
import models.Book;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        //CREATE / SAVE
        Author author1 = new Author("Stephen", "King", 70);
        Author author2 = new Author("Joe", "Pollock", 31);
        Book book1 = new Book("IT", 1986);
        Book book2 = new Book("TBR", 2018);
        DBAuthor.save(author1);
        DBAuthor.save(author2);
        DBBook.save(book1);
        DBBook.save(book2);

        //UPDATE
        Author authorUpdated = DBAuthor.find(author2.getId());
        authorUpdated.setFirstName("J.K.");
        authorUpdated.setLastName("Rowling");
        authorUpdated.setAge(52);
        DBAuthor.update(authorUpdated);

        //FIND
        Author author = DBAuthor.find(author1.getId());
        Book book = DBBook.find(book1.getId());

        //DELETE
        DBAuthor.delete(author2);
        DBBook.delete(book2);

        //LIST ALL
        List<Author> allAuthors = DBAuthor.getAll();
        List<Book> allBooks = DBBook.getAll();



    }

}

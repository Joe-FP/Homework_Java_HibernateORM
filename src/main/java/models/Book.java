package models;

import javax.persistence.*;

@Entity
@Table(name="Books")
public class Book {

    private int id;
    private String title;
    private int publishYear;

    public Book() {
    }

    public Book(String title, int publishYear) {
        this.title = title;
        this.publishYear = publishYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "publishYear")
    public int getPublishYear() {
        return this.publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

}



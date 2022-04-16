package io.com.lab5;

import java.util.Date;
 
public class Book {
	private String title;
	private String author;
    private String category;
	private Date published;
    

    public Book(String title, String author, Date published, String category) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public Date getPublished() {
        return this.published;
    }

    public String getCategory() {
        return this.category;
    }


    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", category='" + getCategory() + "'" +
            ", published='" + getPublished() + "'" +
            "}";
    }


}

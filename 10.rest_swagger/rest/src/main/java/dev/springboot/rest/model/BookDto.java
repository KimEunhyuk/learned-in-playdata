package dev.springboot.rest.model;

public class BookDto {
    private String name;
    private String author;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // source action -> override toString()
    @Override
    public String toString() {
        return "BookDto [author=" + author + ", name=" + name + "]";
    }
    
}
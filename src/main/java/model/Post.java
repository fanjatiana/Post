package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
   private Long id;
    private String title;
    private String author;
    private String content;


    private String createAt;

    public Post( Long id,String title, String author, String content) {
       this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createAt = createAt;
    }

    /*public Long getId() {
        return id;
    }*/

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreateAt() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before : " + now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy"); // + heure : (" dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }

    public Long getId() {
        return id;
    }
}



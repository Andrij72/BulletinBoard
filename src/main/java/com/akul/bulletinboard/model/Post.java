package com.akul.bulletinboard.model;


import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Base64;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String anons;
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    private String full_text;

    @Lob
    @Column(name = "filename")
    private byte[] filename;
    private LocalDate rg_data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    public Post() {
    }

    public Post(String title, byte[] filename, String anons, String full_text, LocalDate rg_data, User usr) {
        super();
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.filename = filename;
        this.rg_data = rg_data;
        this.author = usr;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getRg_data() {
        return rg_data;
    }

    public void setRg_data(LocalDate rg_data) {
        this.rg_data = rg_data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public byte[] getFilename() {
        return filename;
    }

    public void setFilename(byte[] filename) {
        this.filename = filename;
    }

    public String getAuthorName() {
        return author != null ? author.getLastName() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

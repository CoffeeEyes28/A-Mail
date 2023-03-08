package com.amail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String recipient;

    @NonNull
    private String title;
   @NonNull
    private String body;

   @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "sent_at")
    private Date sentAt = new Date();


    public Post(){}

    public Post(String recipient, String title, String body){
        this.recipient = recipient;
        this.title = title;
        this.body = body;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id) && recipient.equals(post.recipient) && title.equals(post.title) && body.equals(post.body) && sentAt.equals(post.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipient, title, body, sentAt);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", recipient='" + recipient + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }

}

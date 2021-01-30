package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    @ManyToOne
    private Topic topic;
    @Lob
    private String content;
//    private String hashtag;
    @ManyToMany()
    private Collection<Hashtag> hashtag;

    protected Post() {
    }

    public Post(String title, String author, Topic topic, String content, Hashtag...hashtags) {
        this.title = title;
        this.author = author;
        this.topic = topic;
        this.content = content;
        this.hashtag = List.of(hashtags); // This may not be needed. Comes into play when I map the PostController.
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() { return author; }

    public Topic getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public void addHashtag(Hashtag inHashtag) {
        hashtag.add(inHashtag);
    }

    public Collection<Hashtag> getHashtag() { return hashtag; }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                ", hashtag='" + hashtag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (author != null ? !author.equals(post.author) : post.author != null) return false;
        if (topic != null ? !topic.equals(post.topic) : post.topic != null) return false;
        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        return hashtag != null ? hashtag.equals(post.hashtag) : post.hashtag == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (hashtag != null ? hashtag.hashCode() : 0);
        return result;
    }
}

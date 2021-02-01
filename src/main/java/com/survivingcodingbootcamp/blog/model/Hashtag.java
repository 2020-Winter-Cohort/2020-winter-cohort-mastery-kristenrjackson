package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> post;

    public Hashtag() {

    }

    public Hashtag(String name) { //, Post...post
        this.name = name;
//        this.post = List.of(post);

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPost() {
        return post;
    }

//    public void addPost(Post inPost) {this.post.add(inPost); }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != hashtag.id) return false;
        return name != null ? name.equals(hashtag.name) : hashtag.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

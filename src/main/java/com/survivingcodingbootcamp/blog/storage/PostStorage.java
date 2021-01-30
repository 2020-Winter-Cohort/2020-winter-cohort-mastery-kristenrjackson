package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostStorage {
    Iterable<Post> retrieveAllPosts();

    Post retrievePostById(long l);

    void save(Post postToAdd);

    void addHashtagToPost(long l, Hashtag hashtagToAdd);
}

package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
//import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public interface HashtagStorage {

    Iterable<Hashtag> retrieveAllHashtags();

    Hashtag retrieveHashtagById(long id);

//    Hashtag retrieveHashtagByName(String name);

    void save(Hashtag hashtagToAdd);
}

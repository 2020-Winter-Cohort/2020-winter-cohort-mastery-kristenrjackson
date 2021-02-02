package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HashtagStorageJpaImpl implements HashtagStorage {
    @Resource
    private HashtagRepository hashtagRepo;

    public HashtagStorageJpaImpl(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public Iterable<Hashtag> retrieveAllHashtags() {
        return hashtagRepo.findAll();
    }


    @Override
    public Hashtag retrieveHashtagById(long id) {
        return hashtagRepo.findById(id).get();
    }

/*    public Hashtag retrieveSingleHashtag(Long id) {
        return hashtagRepo.findById(id).get();
    }*/

    @Override
    public void save(Hashtag hashtagToAdd) {
        hashtagRepo.save(hashtagToAdd);
    }
}

package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import org.springframework.stereotype.Service;

@Service
public interface TopicStorage {
    Iterable<Topic> retrieveAllTopics();

    void save(Topic topicToSave);

    Topic retrieveSingleTopic(long id);

    void addPostToTopic(long id, Post postToAdd);}

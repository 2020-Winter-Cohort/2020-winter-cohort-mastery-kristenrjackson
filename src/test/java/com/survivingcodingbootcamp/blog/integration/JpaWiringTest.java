package com.survivingcodingbootcamp.blog.integration;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
//import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import com.survivingcodingbootcamp.blog.storage.repository.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    HashtagRepository hashtagRepo;
    @Autowired
    private TopicRepository topicRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void postsShouldHaveATopic() {
        Topic testTopic = new Topic("Name");
        topicRepo.save(testTopic);
        Hashtag testHashtag = new Hashtag("scary");
        hashtagRepo.save(testHashtag);

        Post testPost1 = new Post("Title", "An author", testTopic, "Content", testHashtag);
        postRepo.save(testPost1);
        Post testPost2 = new Post("Another Title", "Another author", testTopic, "Content", testHashtag);
        postRepo.save(testPost2);

        entityManager.flush();
        entityManager.clear();

        Topic retrievedTopic = topicRepo.findById(testTopic.getId()).get();

        assertThat(retrievedTopic.getPost()).containsExactlyInAnyOrder(testPost1, testPost2);
    }
    @Test
    public void postShouldHaveAHashtag() {
        Hashtag testHashtag1 = new Hashtag("scary");
        hashtagRepo.save(testHashtag1);
        Hashtag testHashtag2 = new Hashtag("funny");
        hashtagRepo.save(testHashtag2);
    }
}

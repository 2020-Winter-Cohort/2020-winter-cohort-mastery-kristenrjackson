package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    private TopicStorage topicStorage;

    public PostController(PostStorage postStorage, TopicStorage topicStorage) {
        this.postStorage = postStorage;
        this.topicStorage = topicStorage;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id)); // , postStorage.retrieveHashtagById(id)
        return "single-post-template";
    }

    @PostMapping("/addPost") // /{id}
    public String addPost(@RequestParam String title, @RequestParam String author, @RequestParam String topicId, @RequestParam String content) {
        Long id = Long.parseLong(topicId);
        Topic addTopic = topicStorage.retrieveSingleTopic(id);
        Post postToAdd = new Post(title, author, addTopic, content);
        postStorage.save(postToAdd);
        topicStorage.addPostToTopic(id, postToAdd);
        return "redirect:/";
    }
}
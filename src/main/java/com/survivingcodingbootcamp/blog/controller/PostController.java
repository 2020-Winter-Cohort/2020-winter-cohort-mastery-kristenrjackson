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

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }

    @PostMapping("/addPost/{id}")
    public String addPost(@PathVariable long id, @RequestParam String title, @RequestParam String author, @RequestParam String content, String hashtag) {
        return "";
    }
}


// @Controller
// @RequestMapping("/posts")
// public class PostController {
//    private PostStorage postStorage;
//    private TopicStorage topicStorage;
//
//    public PostController(PostStorage postStorage, TopicStorage topicStorage) {
//        this.postStorage = postStorage;
//        this.topicStorage = topicStorage;
//    }
//
//    @GetMapping("/{id}") // Eventually add more than one thing to the model.
//    // public String displaySinglePost(@PathVariable long id, Model model) {
//        public String displaySinglePost(@PathVariable long id, Model model) {
//            model.addAttribute("post", postStorage.retrievePostById(id));
//            return "single-post-template";
//        }
//         model.addAttribute("post", postStorage.retrievePostById(id)); // Before last parentheses, add .getHashtags or .getComments if I need something else to go here.
//         model.addAttribute("hashtag", postStorage.retrievePostById(id).getHashtags);
//         model.addAttribute("hashtag", postStorage.retrievePostById(id).getHashtags());
//         model.addAttribute("comment", postStorage.retrievePostById(id).getComments); Should below be "comment or content"?
//         return "single-post-template";
//     }
//
//    @PostMapping("/addPost/{id}")
//    public String addPost(@PathVariable long id, @RequestParam String title, @RequestParam String author, String content, String hashtag) {
//        Topic topic1 = topicStorage.retrieveSingleTopic(id);
//        Post addedPost = new Post(title, author, topic1, content, hashtag);
//        postStorage.save(addedPost);
//        return "redirect:/posts/" + addedPost.getId();
//            return "";
//    }

    // Include a post mapping dedicated to adding a new post. Include "/addPost/{id}". Id needs to be a post ID. In this mapping, I need to include a model, a path variable, and request param (title, author, content).

    // @GetMapping("/comments/{id}") - specify "addComments". Need to include @Path Variable Long id. If using @RequestParam, NEED to include the capital L for Long id.

    // Will need to create a Comment POJO for comments. Inside, of the Comment class, *** - Include a constructor. The constructor will contain a String for the name of hte comment, establish the class Post, and var args, and then requires an associated Entity. See lines 20-24 of Hashtag class.

    // For PostMapping - Post newPost...look at constructor in the model class.

// }

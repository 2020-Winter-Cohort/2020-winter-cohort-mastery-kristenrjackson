/*
package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
        this.hashtagStorage = hashtagStorage;
    }

    @GetMapping("/{id}")
    public String showSingleHashtag(@PathVariable long id, Model model){
        */
/*Topic sampleTopic = new Topic("Name");
        Post samplePost = new Post ("Title", sampleTopic, "This is a sample post.");*//*

//        Hashtag sampleHashtag = new Hashtag(1L, "scary");

        model.addAttribute("hashtag", hashtagStorage.retrieveHashtagById(1L));

        return "single-hashtag-template";
    }

    //Include postmapping for add hashtag

    //Include request mapping for display all hashtags

}
*/

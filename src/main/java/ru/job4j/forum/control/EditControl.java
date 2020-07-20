package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class EditControl {
    private PostService postService;
    private UserService userService;

    public EditControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String index (
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String answerFor,
            @RequestParam(required = false) String id,
            Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "topic create error");
        } if (id != null) {
            model.addAttribute("oldPost", postService.findById(Integer.parseInt(id)));
        }
        if(answerFor != null) {
            model.addAttribute("answerFor", answerFor);
        }
        model.addAttribute("action", "/create");
        return "edit";
    }

    @PostMapping("/create")
    public String create (
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String oldPostId,
            @RequestParam(required = false) String answerFor) {
        String result = "redirect:/create?error=true";
        if (name != null && description != null && author != null) {
            User user = this.userService.findByName(author);
            Post post = new Post();
            post.setName(name);
            post.setDesc(description);
            post.setAuthor(user);
            if (oldPostId != null) {
                post.setId(Integer.parseInt(oldPostId));
                postService.updatePost(post);
                result = String.format("redirect:/post?id=%s", post.getId());
            } else {
                if (answerFor != null) {
                    int id = Integer.parseInt(answerFor);
                    Post postAnswer = postService.findById(id);
                    postService.addAnswer(postAnswer, post);
                    result = String.format("redirect:/post?id=%s", id);
                } else {
                    post.setTopic(true);
                    postService.add(post);
                    result = String.format("redirect:/post?id=%s", post.getId());
                }
            }
        }
        return result;
    }
}

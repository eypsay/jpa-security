package sayilir.coder.jpasecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sayilir.coder.jpasecurity.model.Post;
import sayilir.coder.jpasecurity.repository.PostRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository posts;


    public PostController(PostRepository posts) {
        this.posts = posts;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findByID(@PathVariable("id") Post post) {
        return post;
    }
}

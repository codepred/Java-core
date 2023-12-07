package pl.kaczmarek.java_core.N_PLUS_1;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {


    private final PostRepository postRepository;

    // N+1 PROBLEM
    @GetMapping("/posts/all")
    public ResponseEntity<Object> getPostsLazy(){
        return ResponseEntity.status(200).body(postRepository.findAll());
    }

    @GetMapping("/posts/all-n-1")
    public ResponseEntity<Object> getPostsEager(){
        return ResponseEntity.status(200).body(postRepository.findAllN1());
    }

    @GetMapping("/posts/random")
    public ResponseEntity<Object> randomData(){
        for (int i = 0; i < 5; i++) {
            Post post = new Post("Author " + i, "Text of post " + i);

            // Adding comments to each post
            for (int j = 0; j < 3; j++) {
                Comment comment = new Comment("Commenter " + j, "Comment text for post " + i);
                post.getComment().add(comment);
            }

            postRepository.save(post);
        }
        return ResponseEntity.status(200).body("READY");
    }

}

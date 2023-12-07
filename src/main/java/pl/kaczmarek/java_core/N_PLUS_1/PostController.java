package pl.kaczmarek.java_core.N_PLUS_1;

import static pl.kaczmarek.java_core.N_PLUS_1.PostDtoMapper.mapToPostDtos;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {


    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    // N+1 PROBLEM
    @GetMapping("/posts/all")
    public ResponseEntity<Object> getPostsLazy(){
        return ResponseEntity.status(200).body(postRepository.findAll());
    }

    @GetMapping("/posts/all-n-1")
    public ResponseEntity<Object> getPostsEager(){
        return ResponseEntity.status(200).body(postRepository.findAllN1NotSafePageable(PageRequest.of(0,10)));
    }

    @GetMapping("/posts/map")
    public ResponseEntity<Object> getPostsMapper(){
        return ResponseEntity.status(200).body(mapToPostDtos(postRepository.findAllN1NotSafePageable(PageRequest.of(0,10))));
    }

    @GetMapping("/posts/allsafe")
    public ResponseEntity<Object> getPostsN1Safe(){
        List<Integer> postIds = postRepository.findAllN1NotSafePageableIds(PageRequest.of(0,10));
        return ResponseEntity.status(200).body(postRepository.findAllN1SAFE(postIds));
    }

    @GetMapping("/posts/random")
    public ResponseEntity<Object> randomData(){
        for (int i = 0; i < 500; i++) {
            Post post = new Post("Author " + i, "Text of post " + i);

            // Adding comments to each post
            for (int j = 0; j < 3; j++) {
                Comment comment = new Comment("Commenter " + j, "Comment text for post " + i);
                commentRepository.save(comment);
                post.addComment(comment);
            }

            postRepository.save(post);
        }
        return ResponseEntity.status(200).body("READY");
    }

}

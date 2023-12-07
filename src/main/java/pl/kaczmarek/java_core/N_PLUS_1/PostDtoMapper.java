package pl.kaczmarek.java_core.N_PLUS_1;

import java.util.List;
import java.util.stream.Collectors;

public class PostDtoMapper {

    private PostDtoMapper() {
    }

    public static List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
            .map(post -> mapToPostDto(post))
            .collect(Collectors.toList());
    }

    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
            .id(post.getId())
            .author(post.getAuthor())
            .text(post.getText())
            .createdAt(post.getCreatedAt()).build();
    }

}

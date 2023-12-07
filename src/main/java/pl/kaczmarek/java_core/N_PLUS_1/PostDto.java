package pl.kaczmarek.java_core.N_PLUS_1;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostDto {

    private Integer id;
    private LocalDateTime createdAt;
    private String author;
    private String text;

}

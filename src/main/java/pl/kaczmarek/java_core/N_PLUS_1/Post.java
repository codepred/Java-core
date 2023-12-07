package pl.kaczmarek.java_core.N_PLUS_1;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> comment = new ArrayList<>();

    public Post(final String author, final String text) {
        this.author = author;
        this.text = text;
    }
}

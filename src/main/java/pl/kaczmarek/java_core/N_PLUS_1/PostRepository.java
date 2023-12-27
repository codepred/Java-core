package pl.kaczmarek.java_core.N_PLUS_1;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // N+1 Clean
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comment")
    List<Post> findAllN1();

    // N+1 Clean
    // Problem with memory
    // firstResult/maxResults specified with collection fetch; applying in memory
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comment")
    List<Post> findAllN1Pageable(Pageable pageable);

    // N+1 Not clean
    @Query("SELECT p FROM Post p")
    List<Post> findAllN1NotSafePageable(Pageable pageable);

    // N+1 SAFE ADD
    @Query("SELECT p.id FROM Post p")
    List<Integer> findAllN1NotSafePageableIds(Pageable pageable);

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comment where p.id in :idsList")
    List<Post> findAllN1SAFE(List<Integer> idsList);

    @Query("SELECT p FROM Post p WHERE p.author = :author")
    List<Post> findAllByAuthorXX(@Param("author") String author);
}

package sayilir.coder.jpasecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sayilir.coder.jpasecurity.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
}

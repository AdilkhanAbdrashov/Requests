package cefdemo.repo;

import cefdemo.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<RequestEntity, Long> {

}

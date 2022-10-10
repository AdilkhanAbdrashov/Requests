package cefdemo.repo;

import cefdemo.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepo extends JpaRepository<RequestEntity, Long> {
//    void deleteRequestById(Long id);
//
//    Optional<RequestEntity> findRequestById(Long id);
}

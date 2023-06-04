package kz.springboot.secondSprintTask.repositories;

import jakarta.transaction.Transactional;
import kz.springboot.secondSprintTask.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandledIsFalse();
    List<ApplicationRequest> findAllByHandledIsTrue();
}

package wdsjk.project.avitotechtrainee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wdsjk.project.avitotechtrainee.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}

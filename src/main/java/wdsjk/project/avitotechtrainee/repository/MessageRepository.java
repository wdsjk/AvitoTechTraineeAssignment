package wdsjk.project.avitotechtrainee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wdsjk.project.avitotechtrainee.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}

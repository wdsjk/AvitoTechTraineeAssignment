package wdsjk.project.avitotechtrainee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wdsjk.project.avitotechtrainee.entity.UserEntity;
import wdsjk.project.avitotechtrainee.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public String addUser(UserEntity user) {
        user.setCreated_at(LocalDate.now());

        userRepository.save(user);
        return String.valueOf(user.getUserId());
    }
}

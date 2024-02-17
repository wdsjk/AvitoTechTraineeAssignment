package wdsjk.project.avitotechtrainee.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wdsjk.project.avitotechtrainee.entity.UserEntity;
import wdsjk.project.avitotechtrainee.repository.UserRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            UserEntity alex = new UserEntity(
                    "alex",
                    LocalDate.of(2012, Month.JANUARY, 15)
            );

            UserEntity maria = new UserEntity(
                    "maria",
                    LocalDate.of(2011, Month.APRIL, 12)
            );

            userRepository.saveAll(List.of(alex, maria));
        };
    }
}

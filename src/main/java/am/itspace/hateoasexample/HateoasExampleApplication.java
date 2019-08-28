package am.itspace.hateoasexample;

import am.itspace.hateoasexample.model.User;
import am.itspace.hateoasexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HateoasExampleApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public HateoasExampleApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HateoasExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder()
                .name("anun")
                .surname("azganun")
                .build();
        User user2 = User.builder()
                .name("poxos")
                .surname("poxosyan")
                .build();
        userRepository.save(user1);
        userRepository.save(user2);
    }
}

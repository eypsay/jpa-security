package sayilir.coder.jpasecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import sayilir.coder.jpasecurity.model.Post;
import sayilir.coder.jpasecurity.model.User;
import sayilir.coder.jpasecurity.repository.PostRepository;
import sayilir.coder.jpasecurity.repository.UserRepository;

@SpringBootApplication
public class JpaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder encoder) {
        return args -> {
            users.save(new User(
                    "user",
                    encoder.encode("pass"),
                    "ROLE_USER"
            ));
            users.save(new User(
                    "admin",
                    encoder.encode("superpass"),
                    "ROLE_USER,ROLE_ADMIN"
            ));
            posts.save(new Post(
                    "Hello world",
                    "hello-world",
                    "Welcome to  my posts",
                    "eyyp"
            ));
            posts.save(new Post(
                    "Intro GraphQl",
                    "intro-graphql",
                    "Welcome to  Intro GraphQl",
                    "eyyp"
            ));

        };
    }

}

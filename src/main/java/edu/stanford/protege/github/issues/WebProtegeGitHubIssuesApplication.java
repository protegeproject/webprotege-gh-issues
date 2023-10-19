package edu.stanford.protege.github.issues;

import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebProtegeJacksonApplication.class)
public class WebProtegeGitHubIssuesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebProtegeGitHubIssuesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

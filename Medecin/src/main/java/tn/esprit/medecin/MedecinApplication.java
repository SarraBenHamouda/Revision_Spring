package tn.esprit.medecin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MedecinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedecinApplication.class, args);
    }

}

package com.example.volunteer_mgm.app_user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class App_UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(App_UserRepository repository) {
        return args -> {
            App_User tamas = new App_User(
                    "Tamas",
                    "Nagy",
                    "tamasnagy2002@gamil.com",
                    "0757290693",
                    LocalDate.of(2002, Month.MARCH, 23),
                    "hash");

            App_User anna = new App_User(
                    "Anna",
                    "Kulcsar",
                    "anna.k@gamil.com",
                    "0757290693",
                    LocalDate.of(2004, Month.NOVEMBER, 4),
                    "hash");

            repository.saveAll(
                    List.of(tamas,anna)
            );
        };
    }
}

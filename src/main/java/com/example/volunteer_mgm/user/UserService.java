package com.example.volunteer_mgm.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    public List<User> getUser() {
        return List.of(
                new User(
                        1L,
                        "Tamas",
                        "Nagy",
                        "tamasnagy2002@gamil.com",
                        "0757290693",
                        LocalDate.of(2002, Month.MARCH, 23),
                        22,
                        "hash")
        );
    }
}

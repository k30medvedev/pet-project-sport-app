package by.kirill.sportsman.app.model.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthday;

}

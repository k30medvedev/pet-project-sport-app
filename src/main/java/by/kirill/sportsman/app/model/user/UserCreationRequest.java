package by.kirill.sportsman.app.model.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthday;

}

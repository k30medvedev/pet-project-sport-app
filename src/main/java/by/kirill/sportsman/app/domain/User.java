package by.kirill.sportsman.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@Entity
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sportsmans")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "min 2 characters max 30 ")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotNull
    @Column(name = "email")
    private String email;

    @PastOrPresent
    @NotNull
    @Column(name = "birthday")
    private LocalDate birthday;
   }


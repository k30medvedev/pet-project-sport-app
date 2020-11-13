package by.kirill.sportsman.app.service.user.EmailNotInUse;
import javax.persistence.*;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class UserUpdateReq {

   @Id
   @NotNull
   private Long id;

   @NotNull
   @Size(min = 2, max = 30, message = "min 2 characters max 30 ")
   private String firstName;

   @NotNull
   @Size(min = 2, max = 30)
   private String lastName;

   @Email
   @NotNull
   private String email;

   @PastOrPresent
   @NotNull
   private LocalDate birthday;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public LocalDate getBirthday() {
      return birthday;
   }

   public void setBirthday(LocalDate birthday) {
      this.birthday = birthday;
   }
}
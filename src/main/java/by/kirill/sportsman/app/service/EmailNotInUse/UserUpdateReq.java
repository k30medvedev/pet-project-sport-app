package by.kirill.sportsman.app.service.EmailNotInUse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.Column;
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
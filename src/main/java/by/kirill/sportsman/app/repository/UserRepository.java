package by.kirill.sportsman.app.repository;

import by.kirill.sportsman.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "DELETE FROM sportsmans WHERE id = ?1", nativeQuery = true)
    User deleteByIdCascade(long id);

    boolean existsByEmailIgnoreCase(String email);
}


package by.kirill.sportsman.app.repository;

import by.kirill.sportsman.app.model.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<RunEntity, Long> {


}

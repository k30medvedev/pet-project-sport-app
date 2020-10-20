package by.kirill.sportsman.app.service;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {

    @Autowired
    private RunRepository runRepository;

    public Run findById(Long id) {
        return runRepository.getOne(id);
    }

    public List<Run> findAllRuns() {
        return runRepository.findAll();
    }

    public Run saveRun(Run run) {
        return runRepository.save(run);
    }

    public void deleteById(Long id) {
        runRepository.deleteById(id);
    }

    public boolean ifExist(Long id) {
        return runRepository.existsById(id);
    }


    public Run updateRun(Long id, Run run) {
        run.setId(id);
        return runRepository.save(run);
    }


}

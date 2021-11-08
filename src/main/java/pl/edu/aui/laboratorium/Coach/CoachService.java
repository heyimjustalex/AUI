package pl.edu.aui.laboratorium.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoachService
{
    private CoachRepository repository;

    @Autowired
    public CoachService(CoachRepository repository)
    {
        this.repository = repository;
    }

    public void save(Coach entity)
    {
        repository.save(entity);
    }

    public void delete(Coach entity)
    {
        repository.delete(entity);
    }

    public Optional<Coach> find(UUID id)
    {
        return repository.find(id);
    }

    public List findAll()
    {
        return repository.findAll();
    }


}

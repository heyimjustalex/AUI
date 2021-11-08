package pl.edu.aui.laboratorium.Footballer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.aui.laboratorium.Coach.Coach;
import pl.edu.aui.laboratorium.Coach.CoachRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class FootballerService
{
    private FootballerRepository  repository;

    @Autowired
    public FootballerService (FootballerRepository repository)
    {
        this.repository = repository;
    }

    public void save(Footballer entity)
    {
        repository.save(entity);
    }

    public void delete(Footballer entity)
    {
        repository.delete(entity);
    }

    public Optional<Footballer> find(UUID id)
    {
        return repository.find(id);
    }

    public List findAll()
    {
        return repository.findAll();
    }
}

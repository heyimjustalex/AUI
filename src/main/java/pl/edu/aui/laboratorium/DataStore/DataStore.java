package pl.edu.aui.laboratorium.DataStore;

import lombok.ToString;
import org.springframework.stereotype.Component;
import pl.edu.aui.laboratorium.Coach.Coach;
import pl.edu.aui.laboratorium.Footballer.Footballer;

import java.util.*;

@Component
@ToString
public class DataStore
{
    private Map<UUID, Footballer> footballers = new HashMap<>();
    private Map<UUID, Coach> coaches = new HashMap<>();

    public Optional<Coach> findCoach(UUID id)
    {
        return Optional.ofNullable(coaches.get(id));
    }

    public List findAllCoaches()
    {
        return new ArrayList<>(coaches.values());
    }

    public void saveCoach(Coach entity)
    {
        coaches.put(entity.getId(),entity);
    }


    public void deleteCoach(Coach entity) {
        coaches.remove(entity.getId());
    }


    public void updateCoach(Coach entity) {
        Optional<Coach> found = this.findCoach(entity.getId());

        if(found.isEmpty())
        {
            this.saveCoach(entity);
        }
        else
        {
            coaches.put(found.get().getId(), entity);
        }
    }


    public Optional<Footballer> findFootballer(UUID id)
    {
        return Optional.ofNullable(footballers.get(id));
    }


    public List findAllFootballers() {
        return new ArrayList<> (footballers.values());
    }


    public void saveFootballer(Footballer entity)
    {
        footballers.put(entity.getId(),entity);
    }


    public void deleteFootballer(Footballer entity) {
        footballers.remove(entity.getId());
    }


    public void updateFootballer(Footballer entity) {
        Optional<Footballer> found = this.findFootballer(entity.getId());

        if(found.isEmpty())
        {
            this.saveFootballer(entity);
        }
        else
        {
            footballers.put(found.get().getId(), entity);
        }
    }
}

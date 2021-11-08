package pl.edu.aui.laboratorium.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.aui.laboratorium.DataStore.DataStore;
import pl.edu.aui.laboratorium.Repository.Repository;
import java.util.*;
@org.springframework.stereotype.Repository

public class CoachRepository implements Repository<Coach,UUID>
{
    DataStore dataStore;
    @Autowired
    CoachRepository (DataStore dataStore)
    {
        this.dataStore = dataStore;
    }

    @Override
    public Optional<Coach> find(UUID id) {
        return dataStore.findCoach(id);
    }

    @Override
    public List findAll() {
        return new ArrayList<>(dataStore.findAllCoaches());
    }

    @Override
    public void save(Coach entity)
    {
        dataStore.saveCoach(entity);
    }

    @Override
    public void delete(Coach entity) {
        dataStore.deleteCoach(entity);
    }

    @Override
    public void update(Coach entity)
    {
        dataStore.updateCoach(entity);
    }
}

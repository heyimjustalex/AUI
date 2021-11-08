package pl.edu.aui.laboratorium.Footballer;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.aui.laboratorium.DataStore.DataStore;
import pl.edu.aui.laboratorium.Repository.Repository;

import java.util.*;

@org.springframework.stereotype.Repository

public class FootballerRepository implements Repository<Footballer,UUID> {
    DataStore dataStore;
    @Autowired
    FootballerRepository (DataStore dataStore)
    {
        this.dataStore = dataStore;
    }

    @Override
    public Optional<Footballer> find(UUID id) {
        return dataStore.findFootballer(id);
    }

    @Override
    public List findAll() {
        return new ArrayList<> (dataStore.findAllFootballers());
    }

    @Override
    public void save(Footballer entity)
    {
        dataStore.saveFootballer(entity);
    }

    @Override
    public void delete(Footballer entity) {
        dataStore.deleteFootballer(entity);
    }

    @Override
    public void update(Footballer entity)
    {
        dataStore.updateFootballer(entity);
    }

}

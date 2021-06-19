package dao;

import java.util.List;

public interface DAO <Entity> {
    void create (Entity entity);
    void update (Entity entity);
    void delete (Entity entity);
    List<Entity> findByAll();

}

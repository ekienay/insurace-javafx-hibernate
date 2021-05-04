package dao;

import java.util.List;

public interface DAO <Entity, Key> {
    void create (Entity entity);
    void update (Entity entity);
    void delete (Entity entity);
    Entity readById(Key key);
    List<Entity> generateContract();

}

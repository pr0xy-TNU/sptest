package dao;

import entities.AlbumsEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class AlbumDao implements IAlbumDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(AlbumsEntity entity) {
        manager.persist(entity);
    }
}

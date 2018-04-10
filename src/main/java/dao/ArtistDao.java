package dao;

import entities.ArtistsEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDao implements IArtistDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(ArtistsEntity entity) {
        if (entity != null) {
            entityManager.persist(entity);
        }
    }
}

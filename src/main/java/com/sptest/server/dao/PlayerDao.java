package com.sptest.server.dao;

import com.sptest.server.dao.model.dto.PlayerDTO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao implements IPlayerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(PlayerDTO playerDTO) {
        entityManager.merge(playerDTO);
    }
}

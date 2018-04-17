package com.sptest.server.dao;

import com.sptest.server.dao.model.dto.PlayerDTO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao implements IPlayerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(PlayerDTO playerDTO) {
        entityManager.merge(playerDTO);
    }

    @Override
    public PlayerDTO findPlayerById(int id) {
        CriteriaQuery<PlayerDTO> query = entityManager.getCriteriaBuilder()
            .createQuery(PlayerDTO.class);
        Root<PlayerDTO> dtoRoot = query.from(PlayerDTO.class);
        return entityManager.find(PlayerDTO.class, id);
    }
}

package com.sptest.server.services;

import com.sptest.server.dao.IPlayerDao;
import com.sptest.server.dao.model.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private IPlayerDao playerDao;


    @Override
    public void save(PlayerDTO playerDTO) {
        playerDao.save(playerDTO);
    }
}

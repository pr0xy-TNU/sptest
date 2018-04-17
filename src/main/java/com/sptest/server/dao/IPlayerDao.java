package com.sptest.server.dao;

import com.sptest.server.dao.model.dto.PlayerDTO;

public interface IPlayerDao {

    void save(PlayerDTO playerDTO);
    PlayerDTO findPlayerById(int id);

}

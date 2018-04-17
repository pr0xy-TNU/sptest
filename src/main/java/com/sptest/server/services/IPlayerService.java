package com.sptest.server.services;

import com.sptest.server.dao.model.dto.PlayerDTO;

public interface IPlayerService {

    void save(PlayerDTO playerDTO);

    PlayerDTO findPlayerByID(int id);

}

package com.sptest.server.services;

import com.sptest.server.dao.IAlbumDao;
import com.sptest.server.dao.IArtistDao;
import com.sptest.server.dao.model.entities.ArtistsEntity;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService implements IArtistService {

    @Autowired
    private IArtistDao artistDao;
    @Autowired
    private IAlbumDao albumDao;

    @Transactional
    @Override
    public void save(ArtistsEntity entity) {
        entity.getAlbums().forEach(album -> albumDao.save(album));
        artistDao.save(entity);
    }
}

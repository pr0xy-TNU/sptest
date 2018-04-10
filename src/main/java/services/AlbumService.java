package services;

import dao.IAlbumDao;
import dao.IArtistDao;
import entities.AlbumsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private IAlbumDao albumDao;
    @Autowired
    private IArtistDao artistDao;

    @Transactional
    @Override
    public void save(AlbumsEntity entity) {
        artistDao.save(entity.getArtist());
        albumDao.save(entity);
    }
}

package com.sptest.server.dao.model.entities;

import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artists", schema = "jpa_test_db")
public class ArtistsEntity {

  private int artistId;
  private String artistName;
  private List<AlbumsEntity> albums;

  @Id
  @Column(name = "artist_id")
  public int getArtistId() {
    return artistId;
  }

  @Basic
  @Column(name = "artist_name")
  public String getArtistName() {
    return artistName;
  }


  @OneToMany(mappedBy = "artist")
  public List<AlbumsEntity> getAlbums() {
    return albums;
  }


  public void setAlbums(List<AlbumsEntity> albums) {
    this.albums = albums;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public void setArtistId(int artistId) {
    this.artistId = artistId;
  }


  public ArtistsEntity(String artistName) {
    this.artistName = artistName;
  }

  public ArtistsEntity(int artistId, String artistName) {
    this(artistName);
    this.artistId = artistId;
  }


  public ArtistsEntity() {
    //default
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtistsEntity that = (ArtistsEntity) o;
    return artistId == that.artistId &&
        Objects.equals(artistName, that.artistName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(artistId, artistName);
  }
}

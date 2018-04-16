package com.sptest.server.dao.model.entities;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "albums", schema = "jpa_test_db")
public class AlbumsEntity {

  private Long id;
  private String albumName;
  private Integer albumYear;
  private ArtistsEntity artist;

  @Id
  @Column(name = "album_id")
  public Long getId() {
    return id;
  }

  @Basic
  @Column(name = "album_name")
  public String getAlbumName() {
    return albumName;
  }

  @Basic
  @Column(name = "album_year")
  public Integer getAlbumYear() {
    return albumYear;
  }

  @ManyToOne
  @JoinColumn(name = "artist_id")
  public ArtistsEntity getArtist() {
    return artist;
  }

  public AlbumsEntity(Long id, String albumName, Integer albumYear) {
    this(albumName, albumYear);
    this.id = id;
  }

  public AlbumsEntity(Long id, String albumName, Integer albumYear, ArtistsEntity entity) {
    this(albumName, albumYear);
    this.id = id;
  }

  public AlbumsEntity(String albumName, Integer albumYear) {
    this.albumName = albumName;
    this.albumYear = albumYear;
  }

  public AlbumsEntity() {
    //default
  }


  public void setArtist(ArtistsEntity artist) {
    this.artist = artist;
  }

  public void setAlbumYear(Integer albumYear) {
    this.albumYear = albumYear;
  }

  public void setId(Long albumId) {
    this.id = albumId;
  }

  public void setArtistId(Long artistId) {
    this.artist.setArtistId(artistId);
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlbumsEntity that = (AlbumsEntity) o;
    return id == that.id &&
        Objects.equals(albumName, that.albumName) &&
        Objects.equals(albumYear, that.albumYear);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, albumName, albumYear);
  }
}

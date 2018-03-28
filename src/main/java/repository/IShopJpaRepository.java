package repository;

import entities.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopJpaRepository extends JpaRepository<ShopEntity, Long> {

}

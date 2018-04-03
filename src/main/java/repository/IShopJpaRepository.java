package repository;

import entities.ShopEntity;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryNameSpaceHandler;



public interface IShopJpaRepository extends JpaRepository<ShopEntity, Long> {

    ShopEntity findShopEntityById(int id);

}

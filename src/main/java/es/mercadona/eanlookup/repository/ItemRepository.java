package es.mercadona.eanlookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mercadona.eanlookup.domain.entity.item.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer>{

}

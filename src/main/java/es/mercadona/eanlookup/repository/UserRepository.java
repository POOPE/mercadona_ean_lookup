package es.mercadona.eanlookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mercadona.eanlookup.domain.entity.security.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String>{

}

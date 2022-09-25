package es.mercadona.eanlookup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mercadona.eanlookup.domain.entity.security.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer>{

	Optional<RoleEntity> findByRole(String role);
}

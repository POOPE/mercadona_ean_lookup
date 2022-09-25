package es.mercadona.eanlookup.repository;

import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.mercadona.eanlookup.domain.entity.supplier.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer>{

	@Query(value="SELECT A.* FROM SUPPLIER A WHERE (A.REFERENCECODE REGEXP :referenceCode)",nativeQuery=true)
	Optional<SupplierEntity> findByReferenceCode(@QueryParam("referenceCode") String referenceCode);
}

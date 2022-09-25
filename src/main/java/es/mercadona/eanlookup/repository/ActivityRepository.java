package es.mercadona.eanlookup.repository;

import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.mercadona.eanlookup.domain.entity.activity.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity,Integer>{

	@Query(value="SELECT A.* FROM ACTIVITY A WHERE (:referenceCode REGEXP A.REFERENCE_CODE)",nativeQuery=true)
	Optional<ActivityEntity> findByReferenceCode(@QueryParam("referenceCode") String referenceCode);
}

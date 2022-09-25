package es.mercadona.eanlookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mercadona.eanlookup.domain.entity.barcode.BarcodeEntity;

public interface BarcodeRepository extends JpaRepository<BarcodeEntity,String>{

}

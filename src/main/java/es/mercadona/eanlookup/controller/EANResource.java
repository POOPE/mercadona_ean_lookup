package es.mercadona.eanlookup.controller;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mercadona.eanlookup.domain.dto.EAN;
import es.mercadona.eanlookup.service.barcode.BarcodeService;


@RestController
@RequestMapping("/EAN")
@Validated
public class EANResource {
	
	@Autowired
	BarcodeService barcodeService;

	@GetMapping("/{EAN}")
	public EAN findByCode(@PathVariable("EAN") @Size(min=13,max=13) String code) {
		return barcodeService.findEAN(code);
	}
}

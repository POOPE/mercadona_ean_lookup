package es.mercadona.eanlookup.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.mercadona.eanlookup.domain.dto.supplier.NewSupplier;
import es.mercadona.eanlookup.domain.dto.supplier.Supplier;
import es.mercadona.eanlookup.domain.entity.supplier.SupplierEntity;
import es.mercadona.eanlookup.service.supplier.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Supplier", description = "Supplier Services")
@RequestMapping("/supplier")
public class SupplierResource {

	@Autowired
	SupplierService supplierService;
	@Autowired
	ModelMapper mapper;
	
	@GetMapping
	public Supplier findById(@RequestParam Integer id) {
		return mapper.map(supplierService.findById(id), Supplier.class);
	}
	
	@PostMapping
	public void create(@Valid @RequestBody NewSupplier newSupplier) {
		supplierService.create(mapper.map(newSupplier, SupplierEntity.class));
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @Valid @RequestBody Supplier supplier) {
		supplierService.update(id, mapper.map(supplier, SupplierEntity.class));
	}
	
	@GetMapping("/all")
	public List<Supplier> findAll(){
		return mapper.map(supplierService.findAll(), new TypeToken<List<Supplier>>(){}.getType());
	}
	
	@DeleteMapping
	public void delete(@RequestParam Integer id) {
		supplierService.delete(id);
	}
}

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

import es.mercadona.eanlookup.domain.dto.item.Item;
import es.mercadona.eanlookup.domain.dto.item.NewItem;
import es.mercadona.eanlookup.domain.entity.item.ItemEntity;
import es.mercadona.eanlookup.service.item.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Item", description = "Item Services")
@RequestMapping("/item")
public class ItemResource {
	
	@Autowired
	ItemService itemService;
	@Autowired
	ModelMapper mapper;
	
	@GetMapping
	public Item findById(@RequestParam Integer id) {
		return mapper.map(itemService.findById(id), Item.class);
	}
	
	@PostMapping
	public void create(@Valid @RequestBody NewItem newItem) {
		itemService.create(mapper.map(newItem, ItemEntity.class));
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @Valid @RequestBody Item item) {
		itemService.update(id, mapper.map(item, ItemEntity.class));
	}
	
	@GetMapping("/all")
	public List<Item> findAll(){
		return mapper.map(itemService.findAll(), new TypeToken<List<Item>>(){}.getType());
	}
	
	@DeleteMapping
	public void delete(@RequestParam Integer id) {
		itemService.delete(id);
	}

}

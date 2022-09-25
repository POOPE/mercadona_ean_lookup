package es.mercadona.eanlookup.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.mercadona.eanlookup.domain.dto.activity.Activity;
import es.mercadona.eanlookup.service.activity.ActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Activity", description = "Activity Services")
@RequestMapping("/activity")
public class ActivityResource {

	@Autowired
	ActivityService activityService;

	@Autowired
	ModelMapper mapper;

	@GetMapping
	public Activity findByReferenceCode(@RequestParam String code) {
		return mapper.map(activityService.findByReferenceCode(code), Activity.class);
	}
}

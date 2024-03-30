package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmCreationDto;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Farm entity.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return farmService.create(farmCreationDto.toEntity());
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Farm> getAllFarms() {
    return farmService.findAll();
  }

  @GetMapping("/{id}")
  public Farm getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    return farmService.findById(id);
  }
}

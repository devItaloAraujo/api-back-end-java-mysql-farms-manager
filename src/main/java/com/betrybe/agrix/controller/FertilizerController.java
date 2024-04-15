package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
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
 * Controller for the Fertilizer entity.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto) {
    Fertilizer createdFertilizer = fertilizerService.create(fertilizerCreationDto.toEntity());
    return FertilizerDto.fromEntity(createdFertilizer);
  }

  /**
   * Returns a list of all fertilizers.
   *
   * @return a list of all fertilizers.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.findAll();
    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

  /**
   * Returns a fertilizer by its id.
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FertilizerDto getFertilizerById(@PathVariable Long id) throws FertilizerNotFoundException {
    Fertilizer fertilizer = fertilizerService.findById(id);
    return FertilizerDto.fromEntity(fertilizer);
  }
}

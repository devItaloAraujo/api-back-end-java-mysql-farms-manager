package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropCreationDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmCreationDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.entity.Crop;
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
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {

    this.farmService = farmService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    Farm createdFarm = farmService.create(farmCreationDto.toEntity());
    return FarmDto.fromEntity(createdFarm);
  }

  /**
   * Returns a list of all farms.
   *
   * @return a list of all farms.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FarmDto> getAllFarms() {
    List<Farm> farms = farmService.findAll();
    return farms.stream()
        .map(FarmDto::fromEntity)
        .toList();
  }

  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    Farm farm = farmService.findById(id);
    return FarmDto.fromEntity(farm);
  }

  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@PathVariable Long farmId, @RequestBody CropCreationDto cropCreationDto)
      throws FarmNotFoundException {
    Crop crop = farmService.createCrop(farmId, cropCreationDto.toEntity());
    return CropDto.fromEntity(crop);
  }

  /**
   * Returns a list of all crops for a farm.
   *
   * @param farmId the farm id
   * @return a list of all crops for a farm
   * @throws FarmNotFoundException if the farm is not found
   */
  @GetMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getCropsByFarmId(@PathVariable Long farmId) throws FarmNotFoundException {
    List<Crop> crops = farmService.findCropsByFarmId(farmId);
    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }
}

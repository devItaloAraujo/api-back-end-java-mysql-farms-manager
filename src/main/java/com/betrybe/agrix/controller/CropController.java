package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Crop entity.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {

    this.cropService = cropService;
  }

  /**
   * Returns a list of all crops.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCrops() {
    List<Crop> crops = cropService.findAll();
    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto getCropById(@PathVariable Long id) throws CropNotFoundException {
    Crop crop = cropService.findById(id);
    return CropDto.fromEntity(crop);
  }

  /**
   * Returns a list of crops between two dates.
   */
  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> searchCropsBetweenDates(
      @RequestParam String start,
      @RequestParam String end
  ) {
    List<Crop> crops = cropService.findCropsBetweenDates(start, end);
    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * Associates a crop with a fertilizer.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String associateCropWithFertilizer(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    cropService.associateCropWithFertilizer(cropId, fertilizerId);
    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * Returns a list of all fertilizers for a crop.
   */
  @GetMapping("/{cropId}/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getFertilizersByCropId(@PathVariable Long cropId)
      throws CropNotFoundException {
    Crop crop = cropService.findById(cropId);
    return crop.getFertilizers().stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }
}
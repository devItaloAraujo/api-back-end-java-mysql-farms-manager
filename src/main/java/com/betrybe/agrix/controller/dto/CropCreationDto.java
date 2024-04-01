package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Crop;

/**
 * Represents a DTO for creating a Crop entity with properties name and size.
 */
public record CropCreationDto(String name, Double plantedArea) {

  /**
   * Converts the DTO to a Crop entity.
   *
   * @return the Crop entity.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    return crop;
  }
}

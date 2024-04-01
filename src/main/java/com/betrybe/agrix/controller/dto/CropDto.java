package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Crop;

/**
 * Represents a DTO for the Crop entity with properties id, name, plantedArea, and farmId.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId
) {

  /**
   * Converts the Crop entity to a Crop DTO.
   *
   * @param crop the Crop entity.
   * @return the Crop DTO.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId());
  }
}

package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Represents a DTO for the Fertilizer entity with properties id, name, brand, and composition.
 */
public record FertilizerDto(
    Long id,
    String name,
    String brand,
    String composition
) {

  /**
   * Converts the Fertilizer entity to a Fertilizer DTO.
   *
   * @param fertilizer the Fertilizer entity.
   * @return the Fertilizer DTO.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition());
  }

}

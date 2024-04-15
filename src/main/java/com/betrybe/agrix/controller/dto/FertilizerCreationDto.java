package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Represents a DTO for creating a Fertilizer entity with properties name, brand, and composition.
 */
public record FertilizerCreationDto(
    String name,
    String brand,
    String composition
) {
  /**
   * Converts the DTO to a Fertilizer entity.
   *
   * @return the Fertilizer entity.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }


}

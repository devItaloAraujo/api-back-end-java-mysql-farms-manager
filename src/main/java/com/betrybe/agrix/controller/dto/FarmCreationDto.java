package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Represents a DTO for creating a Farm entity with properties name and size.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * Converts the DTO to a Farm entity.
   *
   * @return the Farm entity.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}

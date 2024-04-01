package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Represents a DTO for the Farm entity with properties id, name, and size.
 */
public record FarmDto(
    Long id,
    String name,
    Double size) {

  /**
   * Converts the Farm entity to a Farm DTO.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize());
  }
}

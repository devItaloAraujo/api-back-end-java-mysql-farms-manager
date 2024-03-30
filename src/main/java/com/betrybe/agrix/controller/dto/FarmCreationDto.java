package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Represents a DTO for creating a Farm entity with properties name and size.
 */
public record FarmCreationDto(String name, Double size) {

  public Farm toEntity() {
    return new Farm(name, size);
  }
}

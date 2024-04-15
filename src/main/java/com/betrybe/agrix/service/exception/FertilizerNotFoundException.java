package com.betrybe.agrix.service.exception;

/**
 * Represents a FertilizerNotFoundException.
 */
public class FertilizerNotFoundException extends NotFoundException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
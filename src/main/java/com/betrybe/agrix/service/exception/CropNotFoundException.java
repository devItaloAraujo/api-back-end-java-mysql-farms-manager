package com.betrybe.agrix.service.exception;

/**
 * Represents a FarmNotFoundException.
 */
public class CropNotFoundException extends NotFoundException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}

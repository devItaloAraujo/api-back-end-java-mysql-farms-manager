package com.betrybe.agrix.service.exception;

/**
 * Represents a FarmNotFoundException.
 */
public class FarmNotFoundException extends NotFoundException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}

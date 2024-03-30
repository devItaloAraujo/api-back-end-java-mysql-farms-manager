package com.betrybe.agrix.service.exception;


/**
 * Represents a NotFoundException.
 */
public class NotFoundException extends Exception {

  public NotFoundException(String message) {
    super(message);
  }
}
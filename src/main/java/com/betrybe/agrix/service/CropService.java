package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for the Farm entity.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findCropsBetweenDates(String start, String end) {
    LocalDate startDate = LocalDate.parse(start);
    LocalDate endDate = LocalDate.parse(end);
    return cropRepository.findCropsBetweenDates(startDate, endDate);
  }
}
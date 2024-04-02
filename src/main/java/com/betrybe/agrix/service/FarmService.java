package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for the Farm entity.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm findById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id).orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Creates a crop for a farm.
   *
   * @param farmId the farm id
   * @param crop   the crop to be created
   * @return the created crop
   * @throws FarmNotFoundException if the farm is not found
   */
  public Crop createCrop(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = findById(farmId);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

  public List<Crop> findCropsByFarmId(Long farmId) throws FarmNotFoundException {
    Farm farm = findById(farmId);
    return farm.getCrops();
  }

}

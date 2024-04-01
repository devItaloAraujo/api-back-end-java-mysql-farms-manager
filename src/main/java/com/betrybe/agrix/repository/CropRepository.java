package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Crop entity.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

}

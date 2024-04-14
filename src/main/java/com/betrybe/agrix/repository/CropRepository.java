package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Crop entity.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
  @Query("SELECT c FROM Crop c WHERE c.harvestDate BETWEEN :start AND :end")
  List<Crop> findCropsBetweenDates(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
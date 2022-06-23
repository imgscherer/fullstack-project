package com.course.fullstackprojectbackend.repositories;

import com.course.fullstackprojectbackend.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}

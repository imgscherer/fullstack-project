package com.course.fullstackprojectbackend.repositories;

import com.course.fullstackprojectbackend.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}

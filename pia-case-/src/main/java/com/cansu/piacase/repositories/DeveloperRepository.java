package com.cansu.piacase.repositories;

import com.cansu.piacase.models.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperModel, Long> {
}

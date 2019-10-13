package edu.mum.cs.cs425.dprwakanda.repository;

import edu.mum.cs.cs425.dprwakanda.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}

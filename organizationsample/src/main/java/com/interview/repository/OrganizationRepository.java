package com.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.model.OrganizationDetails;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationDetails, Long>{

}

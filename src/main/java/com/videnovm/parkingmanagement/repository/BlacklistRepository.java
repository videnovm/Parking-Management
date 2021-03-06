package com.videnovm.parkingmanagement.repository;

import com.videnovm.parkingmanagement.model.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
}

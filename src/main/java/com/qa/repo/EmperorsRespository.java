package com.qa.repo;

import com.qa.domain.Emperor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmperorsRespository extends JpaRepository<Emperor, Long> {


}

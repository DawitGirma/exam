package com.exam.etdm.repository;

import com.exam.etdm.model.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete,Long>
{

}

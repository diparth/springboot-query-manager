package com.diparth.springbootapp.repositories;

import com.diparth.springbootapp.entities.QueryReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueryRepository extends JpaRepository<QueryReport, Long> {
    
    @Query(value = "SELECT i FROM QueryReport i WHERE markedAsPrivate = false")
    List<QueryReport> findAllButPrivate();

    List<QueryReport> findAllByEmail(String email);
}

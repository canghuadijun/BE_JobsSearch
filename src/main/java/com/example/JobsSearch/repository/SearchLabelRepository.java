package com.example.JobsSearch.repository;

import com.example.JobsSearch.model.util.SearchLabel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchLabelRepository extends JpaRepository<SearchLabel, Long> {
    Boolean existsByName(String name);
}

package com.example.crud.poorganizer.repositories;

import com.example.crud.poorganizer.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface ProjectRepository extends JpaRepository<Project, String> {
        List<Project> findAllBySituationTrue();

    }


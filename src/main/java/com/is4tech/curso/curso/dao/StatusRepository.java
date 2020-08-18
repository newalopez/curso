package com.is4tech.curso.curso.dao;

import com.is4tech.curso.curso.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}

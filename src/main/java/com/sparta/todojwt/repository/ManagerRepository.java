package com.sparta.todojwt.repository;

import com.sparta.todojwt.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findAllByTodoId(Long id);
}

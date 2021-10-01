package com.dantas.strategicplanning.repository;

import com.dantas.strategicplanning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

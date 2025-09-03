package com.example.matchApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.matchApp.model.MatchOdd;

@Repository
public interface MatchOddDAO extends JpaRepository<MatchOdd, Integer> {}

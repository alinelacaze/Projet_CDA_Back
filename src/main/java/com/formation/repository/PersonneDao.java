package com.formation.repository;

import com.formation.entity.Colonie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.formation.entity.Personne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonneDao extends JpaRepository<Personne, Long> {

    Personne findById(long id);

    List<Personne> findByColonieId(long id);

    @Query("SELECT o FROM Personne o WHERE o.login = :login AND o.password = :password")
    Personne findByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    Personne findByLogin(String login);
}

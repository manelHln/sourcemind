package com.sourcemind.employeemanagement.repository;

import com.sourcemind.employeemanagement.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT u FROM Utilisateur u WHERE u.email = ?1")
    Optional<Utilisateur> findByUsername(String username);

    Optional<Utilisateur> findByEmail(String email);

    /*
    @Query("SELECT u FROM User u WHERE u.email = :username")
    Optional<User> findByUsername1(@Param("username") String username);

    @Query(value = "SELECT u FROM user u WHERE u.email = ?1", nativeQuery = true)
    Optional<User> findByUsername2(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByLastnameAndFirstnameOrdeOrderByLastnameDesc(String lastname, String firstname);

     */



}

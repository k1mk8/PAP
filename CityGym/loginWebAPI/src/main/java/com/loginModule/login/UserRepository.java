package com.loginModule.login;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.springframework.http.HttpHeaders.FROM;

public interface UserRepository extends JpaRepository<Person, Long> {

    @Query("FROM Person  WHERE login = ?1")
        List<Person> findByLogin(String login);



}

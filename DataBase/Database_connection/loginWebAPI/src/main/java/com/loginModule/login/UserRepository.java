package com.loginModule.login;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.springframework.http.HttpHeaders.FROM;

public interface UserRepository extends JpaRepository<Person, Long> {

    @Query("FROM Person  WHERE login = ?1")
    List<Person> findByLogin(String login);

    @Query("SELECT p.login FROM Person p WHERE p.login = ?1")
    String findByLogin_v2(String login);


    @Query(value = "CALL create_adres_and_czlonek(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15)", nativeQuery = true)
    void create_adres_and_czlonek(String country, String city,
                                  String postal_code, String street,
                                  String building_nr, String flat_nr,
                                  int region,String tren_flag,
                                  String name,String surname,
                                  int PES,  String birth_date,
                                  String login, String pass,
                                  String e_mail);
}

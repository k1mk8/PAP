package com.loginModule.login;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.springframework.http.HttpHeaders.FROM;

public interface EventRepository extends JpaRepository<Event, Long> {

//    @Query(value = "CALL create_new_event(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15)", nativeQuery = true)
//    void addNewEvent(String rodzaj, String opis, int przedzialy);
}

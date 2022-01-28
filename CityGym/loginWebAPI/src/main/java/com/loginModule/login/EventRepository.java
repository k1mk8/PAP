package com.loginModule.login;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.springframework.http.HttpHeaders.FROM;


public interface EventRepository extends JpaRepository<Event, Long> {


    @Query(value = "SELECT * FROM eventy WHERE event_id = ?1", nativeQuery = true)
    List<Event> getEventByID(int event_id);

    @Query(value = "SELECT * FROM eventy WHERE opis = ?1", nativeQuery = true)
    List<Event> getEventByDesc(String opis);



    @Query(value="CALL add_new_event(?1,?2,?3,?4,?5)", nativeQuery = true )
    void addEvent(String rodzaj, String opis, int dzien_dzien_id, int przedzialy_przedzial_id, int silownie_id_silowni);
}

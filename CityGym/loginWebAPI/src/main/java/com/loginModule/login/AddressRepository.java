package com.loginModule.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("FROM Address  WHERE kraj = ?1 AND  miasto = ?2 AND kod_pocztowy = ?3 AND ulica = ?4 AND nr_budynku =?5 AND  nr_mieszkania = ?6 AND region = ?7")
    int findAddressId(String kraj, String miasto, String kod_pocztowy, String ulica,
                     String nr_budynku, String nr_mieszkania, int region);

//    @Query(value = "CALL create_adres_and_czlonek(:country,:city,:postal_code,:street,building_nr," +
//            ":flat_nr :region:tren_flag :name, :surname, :PES, :birth_date, :join_date, :login, :pass, :e_mail)", nativeQuery = true)
//    void create_adres_and_czlonek(@Param ("country") String country, @Param ("city") String city,
//                                  @Param ("postal_code") String postal_code,@Param ("street") String street,
//                                  @Param ("building_nr") String building_nr, @Param ("flat_nr") String flat_nr,
//                                  @Param ("region") int region,@Param ("tren_flag") String tren_flag,
//                                  @Param ("name") String name,@Param ("surname") String surname,
//                                  @Param ("PES") int PES, @Param ("birth_date") String birth_date,
//                                  @Param ("join_date") String join_date, @Param ("login") String login,
//                                  @Param ("pass") String pass, @Param ("e_mail") String e_mail);
//


}
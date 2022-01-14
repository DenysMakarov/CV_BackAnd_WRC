package cv.backend.dao;

import cv.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
//    @Query("select a from Address a where a.city=?1 and a.country=?2 and a.street=?3")
//    Address findAddressByCityAndCountryAndStreet(String city, String country, String Street);

    @Query("select a from Address a where a.country=?1 and a.city=?2 and a.street=?3")
    Address findAddressByCountryAndCityAndStreet(String country, String city, String street);
}

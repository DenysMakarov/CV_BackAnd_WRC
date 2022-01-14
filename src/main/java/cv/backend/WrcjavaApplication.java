package cv.backend;

import cv.backend.dao.AddressRepository;
import cv.backend.dao.UserRepository;
import cv.backend.model.Address;
import cv.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WrcjavaApplication implements CommandLineRunner {
    public static UserRepository userRepository;
    public static AddressRepository addressRepository;

    @Autowired
    public WrcjavaApplication(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WrcjavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        if (userRepository.existsById(1000L)) {
        Address address = new Address("UK", "London", "42 street");
        addressRepository.save(address);
        Address address2 = new Address("USA", "NewYork", "15 street");
        addressRepository.save(address2);
        Address address3 = new Address("CANADA", "Vancouver", "77 street");
        addressRepository.save(address3);
//        Address address4 = new Address("Uk", "London", "42 street");
//        addressRepository.save(address4);


        Set<String> roles = new HashSet<>();
        Set<String> roles2 = new HashSet<>();
        roles.add("admin");
        roles2.add("user");
        User user1 = new User("Tor", "Tor", "Valhalsky", "tor@gmail.com", "1234", 1234567890, "User", LocalDate.of(1985, 04, 07), address);
        User user2 = new User("Hulk","Hulk", "Hulkavic", "hulk@gmail.com", "1234", 1234567890, "User", LocalDate.of(1985, 04, 07), address2);
        User user3 = new User("IronMan","IronMan", "IronManovich", "iron@gmail.com", "1234", 1234567890, "User", LocalDate.of(1985, 04, 07), address3);
//        User user4 = new User("Terminator","Terminator", "Terminatovich", "terminator@gmail.com", "1234", 1234567890, "User", LocalDate.of(1985, 04, 07), address);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
//        userRepository.save(user4);

//        }

    }
}

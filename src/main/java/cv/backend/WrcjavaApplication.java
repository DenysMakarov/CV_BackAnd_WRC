package cv.backend;

import cv.backend.dao.AddressRepository;
import cv.backend.dao.UserRepository;
import cv.backend.model.Address;
import cv.backend.model.User;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.HashSet;

@SpringBootApplication
public class WrcjavaApplication implements CommandLineRunner {
    public static UserRepository userRepository;
    public static AddressRepository addressRepository;

    @Autowired
    public WrcjavaApplication(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

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

        String password = passwordEncoder.encode("1234");

        User user1 = new User("Tor", "Valhalsky", "tor@gmail.com", "1234", "1234567890",  LocalDate.of(1985, 04, 07), address, new HashSet<>());
        User user2 = new User("Hulk", "Hulkavic", "hulk@gmail.com", "1234", "1234567890",  LocalDate.of(1985, 04, 07), address2, new HashSet<>());
        User user3 = new User("IronMan", "IronManovich", "iron@gmail.com", "1234", "1234567890",  LocalDate.of(1985, 04, 07), address3, new HashSet<>());
        user1.setRoles("USER"); user1.setPassword(password);
        user2.setRoles("USER"); user2.setPassword(password);
        user3.setRoles("USER"); user3.setPassword(password);


        if(!userRepository.existsById("admin")) {
            password = passwordEncoder.encode("admin");
            User admin = new User("admin", "admin", "iron@gmail.com", password, "1234567890",  LocalDate.of(1985, 04, 07), address3, new HashSet<>());
            admin.setRoles("ADMINISTRATOR MODErator uSer");
            userRepository.save(admin);
//            String password = passwordEncoder.encode("admin");
//            UserAccount userAccount = new UserAccount("admin", password, "", "");
//            userAccount.addRole("USER".toUpperCase());
//            userAccount.addRole("MODERATOR".toUpperCase());
//            userAccount.addRole("ADMINISTRATOR".toUpperCase());
//            repository.save(userAccount);
        }

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}

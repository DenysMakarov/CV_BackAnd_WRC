package cv.backend;

import cv.backend.dao.AddressRepository;
import cv.backend.dao.EventRepository;
import cv.backend.dao.TicketsRepository;
import cv.backend.dao.UserRepository;
import cv.backend.dto.events.EventParamDto;
import cv.backend.model.Address;
import cv.backend.model.Event;
import cv.backend.model.User;
import cv.backend.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class WrcjavaApplication implements CommandLineRunner {
    public UserRepository userRepository;
    public AddressRepository addressRepository;
    public EventRepository eventRepository;
    public TicketsRepository ticketsRepository;
    public PasswordEncoder passwordEncoder;
    UserService userService;

    @Autowired
    public WrcjavaApplication(UserRepository userRepository, AddressRepository addressRepository, EventRepository eventRepository, TicketsRepository ticketsRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.eventRepository = eventRepository;
        this.ticketsRepository = ticketsRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WrcjavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("UK", "London", "42 street");
        addressRepository.save(address);
        Address address2 = new Address("USA", "NewYork", "15 street");
        addressRepository.save(address2);
        Address address3 = new Address("CANADA", "Vancouver", "77 street");
        addressRepository.save(address3);


        String password = passwordEncoder.encode("1234");

        User user1 = new User("Tor", "Valhalsky", "tor@gmail.com", "1234", "1234567890", LocalDate.of(1985, 04, 07), address, new HashSet<>());
        User user2 = new User("Hulk", "Hulkavic", "hulk@gmail.com", "1234", "1234567890", LocalDate.of(1985, 04, 07), address2, new HashSet<>());
        User user3 = new User("IronMan", "IronManovich", "iron@gmail.com", "1234", "1234567890", LocalDate.of(1985, 04, 07), address3, new HashSet<>());
        user1.setRoles("USER");
        user1.setPassword(password);
        user2.setRoles("USER");
        user2.setPassword(password);
        user3.setRoles("USER");
        user3.setPassword(password);

        User admin = new User("admin", "admin", "admin@gmail.com", password, "01001100101", LocalDate.of(1985, 04, 07), address3, new HashSet<>());
        if (!userRepository.existsById("admin")) {
            password = passwordEncoder.encode("admin");
            admin.setPassword(password);
            admin.setRoles("ADMINISTRATOR MODErator uSer");
            userRepository.save(admin);
        }
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Event event1 = new Event("FIA WRC", "OAE", "I`am created a unique visual system and strategy across the wide existing spectrum of...", "url(img/rally_c3_4.jpg)", LocalDate.of(2022, 7, 8), 210.00);
        Event event2 = new Event("DAKAR RALLY", "FRANCE", "I`am created a unique visual system and strategy across the wide existing spectrum of...", "url(img/Dakar_rally_toyo.jpg)", LocalDate.of(2022, 3, 11), 375.00);
        Event event3 = new Event("BAMAKO RALLY", "HUNGARY", "I`am created a unique visual system and strategy across the wide existing spectrum of...", "url(img/Bamaco.jpg)", LocalDate.of(2021, 8, 12), 175.00);
        Event event4 = new Event("GRAND PRI F1", "MONTE-CARLO", "I`am created a unique visual system and strategy across the wide existing spectrum of...", "url(img/f1_maclaren_1.jpg)", LocalDate.of(2022, 4, 10), 215.00);
        Event event5 = new Event("OTHER EVENTS", "UNKNOWN YET", "I`am created a unique visual system and strategy across the wide existing spectrum of...", "url(img/f1_maclaren_2.jpg)", LocalDate.of(2023, 9, 11), 0.00);
        List<Event> events = Arrays.asList(event1, event2, event3, event4, event5);
        events.stream().forEach(el -> eventRepository.save(el));


        userService.addTicket(admin.getLogin(), new EventParamDto(event1.getTitle(), event1.getDate()));
        userService.addTicket(admin.getLogin(), new EventParamDto(event1.getTitle(), event1.getDate()));
        userService.addTicket(user1.getLogin(), new EventParamDto(event2.getTitle(), event2.getDate()));
        userService.addTicket(user1.getLogin(), new EventParamDto(event3.getTitle(), event3.getDate()));
        userService.addTicket(user2.getLogin(), new EventParamDto(event3.getTitle(), event3.getDate()));
    }
}

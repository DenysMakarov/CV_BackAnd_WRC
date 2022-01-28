package cv.backend.service.userService;

import cv.backend.dao.AddressRepository;
import cv.backend.dao.EventRepository;
import cv.backend.dao.TicketsRepository;
import cv.backend.dao.UserRepository;
import cv.backend.dto.address.AddressDto;
import cv.backend.dto.address.AddressResponseDto;
import cv.backend.dto.events.EventParamDto;
import cv.backend.dto.tickets.TicketForUserDto;
import cv.backend.dto.users.UserDto;
import cv.backend.dto.users.UserResponseDto;
import cv.backend.model.Address;
import cv.backend.model.Event;
import cv.backend.model.Ticket;
import cv.backend.model.User;
import cv.backend.model.exeptions.EntityConflictException;
import cv.backend.model.exeptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    UserRepository userRepository;
    AddressRepository addressRepository;
    TicketsRepository ticketsRepository;
    ModelMapper modelMapper;
    EventRepository eventRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, TicketsRepository ticketsRepository, ModelMapper modelMapper, EventRepository eventRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.ticketsRepository = ticketsRepository;
        this.modelMapper = modelMapper;
        this.eventRepository = eventRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        if (userRepository.existsById(user.getLogin())) throw new EntityConflictException();

        Address address = addressRepository.findAddressByCountryAndCityAndStreet(
                user.getAddress().getCountry(),
                user.getAddress().getCity(),
                user.getAddress().getStreet());
        if (address == null) {
            address = user.getAddress();
            addressRepository.save(address);
        }
        user.setRoles("USER");
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setAddress(address);
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(String login) {
        User user = userRepository.getUserByLogin(login);
        if (user == null) throw new EntityNotFoundException();
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserResponseDto loginUser(String login) {
        User user = userRepository.findById(login)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public Set<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toSet());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto removeUser(String id) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public AddressResponseDto getAddressByAddressDto(AddressDto addressDto) {
        Address address = addressRepository.findAddressByCountryAndCityAndStreet(addressDto.getCountry(), addressDto.getCity(), addressDto.getStreet());
        if (address == null) throw new EntityNotFoundException();
        return modelMapper.map(address, AddressResponseDto.class);
    }

    @Override
    @Transactional
    public TicketForUserDto addTicket(String login, EventParamDto eventParamDto) {
        User user = userRepository.getUserByLogin(login);
        Event event = eventRepository.findEventByTitleAndDate(eventParamDto.getTitle(), eventParamDto.getDate());
        if (user == null || event == null) throw new EntityNotFoundException();

        Ticket ticket = new Ticket(event.getTitle(), event.getPlace(),
                user.getLogin(), user.getUsername(),
                user.getEmail(), user, event.getDate(),
                event, event.getPrice());

        ticket.setUser(user);
        ticket.setEvent(event);
        user.addTicket(ticket);
        event.addTicketToEvent(ticket);
        userRepository.save(user);
        eventRepository.save(event);
        return modelMapper.map(ticket, TicketForUserDto.class);
    }
}

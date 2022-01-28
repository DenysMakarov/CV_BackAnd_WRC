package cv.backend.security;

import cv.backend.dao.UserRepository;
import cv.backend.model.User;
import cv.backend.model.exeptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Locale;


@Service
public class UserDetailService implements UserDetailsService {
    UserRepository repository;

    @Autowired
    public UserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findById(username).orElseThrow(EntityNotFoundException::new);
        String[] roles = Arrays.stream(user.getRoles().split(" "))
                .map(r -> "ROLE_" + r.toUpperCase(Locale.ROOT))
                .toArray(String[]::new);
        return new org.springframework.security.core.userdetails.User(username,
                user.getPassword(), AuthorityUtils.createAuthorityList(roles));
    }

//    UserAccount userAccount = repository.findById(username)
//            .orElseThrow(() -> new UsernameNotFoundException(username));
//    String[] roles = userAccount.getRoles()
//            .stream()
//            .map(r -> "ROLE_" + r.toUpperCase())
//            .toArray(String[]::new);
//		return new User(username, userAccount.getPassword(),
//				AuthorityUtils.createAuthorityList(roles));
}

package orange.exchange.service.impl;

import lombok.RequiredArgsConstructor;
import orange.exchange.exception.EntityNotFoundException;
import orange.exchange.model.entity.User;
import orange.exchange.repository.UserRepository;
import orange.exchange.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Could not find user with username: " + username));
    }
}

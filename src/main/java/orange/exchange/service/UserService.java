package orange.exchange.service;

import orange.exchange.model.entity.User;

public interface UserService {
    User getByUsername(String username);
}

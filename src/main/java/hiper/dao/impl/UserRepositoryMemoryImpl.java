package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.UserRepository;
import hiper.models.User;

import java.util.Optional;

public class UserRepositoryMemoryImpl extends RepositoryMemoryImpl<Long, User> implements UserRepository {
    public UserRepositoryMemoryImpl() {
    }

    public UserRepositoryMemoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}

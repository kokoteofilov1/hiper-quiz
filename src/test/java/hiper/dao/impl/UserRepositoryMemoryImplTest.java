package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.UserRepository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.models.Gender;
import hiper.models.Role;
import hiper.models.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class UserRepositoryMemoryImplTest {
    private static final List<User> SAMPLE_USERS = List.of(
            new User("peter.johnson", "peterj@gmail.com", "somePassword",
                    Gender.MALE, Role.PLAYER),
            new User("quizGamerx", "dolphinlover@yahoo.com", "ilovedolphins",
                    Gender.MALE, Role.PLAYER),
            new User("gamerGirl23", "jessica_peterson@email.com", "password123",
                    Gender.FEMALE, Role.ADMINISTRATOR)
    );

    private static final long FIRST_USER_ID = 1L;

    private static final User NEW_USER = new User("ivantodorov", "ivan_todorov@gmail.com", "randomPassword",
            Gender.MALE, Role.PLAYER);

    private static final User UPDATE_FIRST = new User(1L, "ivantodorov123", "ivantodorov@email.com", "changedPassword",
            Gender.MALE, Role.PLAYER);

    private KeyGenerator<Long> keyGenerator;

    private UserRepository userRepository;

    private User user;

    private User updatedUser;

    @BeforeEach
    void setUp() {
        keyGenerator = new LongKeyGenerator();
        userRepository = new UserRepositoryMemoryImpl(keyGenerator);
    }

    @Test
    void findAll() {
        fillUserRepository();
        List<User> result = userRepository.findAll();

        assertNotNull(result, "Fetched users list is null.");
        assertEquals(SAMPLE_USERS.size(), result.size(), "Fetched users size is different.");
    }

    @Test
    void findById() {
        fillUserRepository();
        Optional<User> result = userRepository.findById(FIRST_USER_ID);

        assertTrue(result.isPresent(), "User is null.");
        assertEquals(FIRST_USER_ID, result.get().getId(), "User ID is wrong.");
        assertEquals(SAMPLE_USERS.get(0), result.get(), "Users instance is different.");
    }

    @Test
    void create() {
        assertDoesNotThrow(() -> {
            user = userRepository.create(NEW_USER);
        }, "create() throws exception.");
        assertNotNull(user, "User is null.");
        assertNotNull(user.getId(), "User's ID is null.");
        assertEquals(NEW_USER, user, "Created user does not match argument entity.");
        assertEquals(FIRST_USER_ID, user.getId(), "ID of user does not equal first item ID.");
    }

    @Test
    void update() throws MissingKeyGeneratorException, EntityAlreadyExistsException {
        userRepository.create(NEW_USER);

        assertDoesNotThrow(() -> {
            updatedUser = userRepository.update(UPDATE_FIRST);
        });
        assertNotNull(updatedUser, "Updated user is null.");
        assertNotEquals(NEW_USER, updatedUser, "User was not updated.");
        assertEquals(FIRST_USER_ID, updatedUser.getId(), "Updated user's ID is incorrect.");
        assertEquals(UPDATE_FIRST.getUsername(), updatedUser.getUsername(), "Usernames do not match.");
        assertEquals(UPDATE_FIRST.getEmail(), updatedUser.getEmail(), "Emails do not match.");
        assertEquals(UPDATE_FIRST.getPassword(), updatedUser.getPassword(), "Passwords do not match.");
    }

    @Test
    void deleteById() {
        fillUserRepository();

        assertDoesNotThrow(() -> {
            userRepository.deleteById(FIRST_USER_ID);
        }, "deleteById() throws exception.");
        assertNotEquals(SAMPLE_USERS.size(), userRepository.findAll().size(), "Repository size did not change after delete.");
        assertEquals(SAMPLE_USERS.size() - 1, userRepository.findAll().size(), "Repository size is wrong after delete.");
    }

    @Test
    void count() {
        fillUserRepository();

        assertEquals(SAMPLE_USERS.size(), userRepository.count());
    }

    @Test
    void findByUsername() {
        fillUserRepository();
        Optional<User> found = userRepository.findByUsername("peter.johnson");

        assertTrue(found.isPresent());
        assertEquals(FIRST_USER_ID, found.get().getId(), "Found user's ID does not match.");
        assertEquals("peter.johnson", found.get().getUsername(), "Found user's username does not match.");
        assertEquals("peterj@gmail.com", found.get().getEmail(), "Found user's email does not match.");
        assertEquals("somePassword", found.get().getPassword(), "Found user's password does not match.");
        assertEquals(Gender.MALE, found.get().getGender(), "Found user's gender does not match.");
        assertEquals(Role.PLAYER, found.get().getRole(), "Found user's role does not match.");
    }

    private void fillUserRepository() {
        for (User sampleUser : SAMPLE_USERS) {
            try {
                userRepository.create(sampleUser);
            } catch (MissingKeyGeneratorException e) {
                log.error("Missing key generator.", e);
            } catch (EntityAlreadyExistsException e) {
                log.error("Error adding users to repository.", e);
            }
        }
    }
}

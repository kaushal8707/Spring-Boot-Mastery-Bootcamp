package org.net.spring.boot.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.net.spring.boot.app.entity.User;
import org.net.spring.boot.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void testFindByUserName_when_user_present_in_db(){
        Assertions.assertNotNull(userRepository.findByUserName("kaushal"));
    }

    @Disabled
    @Test
    void testFindByUserName_when_user_not_present_in_db(){
        Assertions.assertNull((userRepository.findByUserName("abc")));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "12, 8, 4",
            "11, 6, 6"
    })
    void addTest(int expected, int a, int b){
        Assertions.assertEquals(expected, a+b);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "kaushal",
            "alok",
            "akash"
    })
    void testFindByUserName_with_multiple_user_value(String uname){
        Assertions.assertNotNull(userRepository.findByUserName(uname));
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    void testsavUser_save_multiple_users(User user){
        Assertions.assertTrue(userService.saveUser(user));
    }

    @ParameterizedTest
    @ArgumentsSource(UserNameArgumentProvider.class)
    void findByUserName_using_argument_source_test(String userName){
        User user = userRepository.findByUserName(userName);
        Assertions.assertNotNull(user);
    }
}

package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.config.TestConfiguration;
import hu.unideb.nursenotes.service.imp.imp.UserServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class _2UserServiceFindTest {

    private static final String FIRSTNAME = "userFirstName";

    private static final String LASTNAME = "userLastName";

    private static final String USERNAME = "userUsername";

    private static final String PASSWORD = "userPassword";

    private static final String EMAIL = "userEmail";

    private static final LocalDate CREATEDDATE = LocalDate.now();

    @Autowired
    private UserServiceImp userServiceImp;

    private RegistrationRequest userRequest;

    private User addedUser;

    @Before
    public void setUp() {

        userRequest = RegistrationRequest.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .username(USERNAME)
                .password(PASSWORD)
                .email(EMAIL)
                .createdDate(CREATEDDATE)
                .build();

        addedUser = User.builder()
                .id(1L)
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .username(USERNAME)
                .password(PASSWORD)
                .email(EMAIL)
                .createdDate(CREATEDDATE)
                .build();
    }

    @Test
    public void _2findByUsernameTest() throws Exception {
        User savedUser = userServiceImp.findByUsername(userRequest.getUsername());

        Assert.assertNotNull(savedUser.getId());
        Assert.assertNotNull(savedUser.getFirstName());
        Assert.assertNotNull(savedUser.getLastName());
        Assert.assertNotNull(savedUser.getUsername());
        Assert.assertNotNull(savedUser.getPassword());
        Assert.assertNotNull(savedUser.getEmail());
        Assert.assertNotNull(savedUser.getCreatedDate());
        Assert.assertEquals(savedUser,addedUser);
    }
}

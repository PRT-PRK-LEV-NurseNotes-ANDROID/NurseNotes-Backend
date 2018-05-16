package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.config.TestConfiguration;
import hu.unideb.nursenotes.service.imp.imp.ClientServiceImp;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class _6ClientServiceFindUserTest {

    private static final String FIRSTNAME = "clientFirstName";

    private static final String LASTNAME = "clientLastName";

    private static final String ADDRESS = "clientAddress";

    private static final String PHONENUMBER = "clientPhoneNumber";

    private static final String SIGNATURE = "clientSignature";

    private static final int AGE = 50;

    private static final int WAGE = 200;

    @Autowired
    private ClientServiceImp clientService;

    private User user;

    @Before
    public void setUp() throws BaseException {

        user = User.builder()
                .id(1L)
                .firstName("userFirstName")
                .lastName("userLastName")
                .username("userUsername")
                .password("userPassword")
                .email("userEmail")
                .createdDate(LocalDate.now())
                .build();

        Client clientA = Client.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .address(ADDRESS)
                .phoneNumber(PHONENUMBER)
                .age(AGE)
                .signature(SIGNATURE)
                .wage(WAGE)
                .user(user)
                .build();
        clientService.addClient(clientA);

        Client clientB = Client.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .address(ADDRESS)
                .phoneNumber(PHONENUMBER)
                .age(AGE)
                .signature(SIGNATURE)
                .wage(WAGE)
                .user(user)
                .build();
        clientService.addClient(clientB);

        Client addedClientA = Client.builder()
                .id(1L)
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .address(ADDRESS)
                .phoneNumber(PHONENUMBER)
                .age(AGE)
                .signature(SIGNATURE)
                .wage(WAGE)
                .user(user)
                .build();

        Client addedClientB = Client.builder()
                .id(2L)
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .address(ADDRESS)
                .phoneNumber(PHONENUMBER)
                .age(AGE)
                .signature(SIGNATURE)
                .wage(WAGE)
                .user(user)
                .build();
    }

    @Test
    public void findUsersClientTest() {

        List<ClientResponse> foundClients = clientService.findUsersClient(user);

        Assert.assertNotNull(foundClients);
        Assert.assertEquals(4, foundClients.size());
    }
}

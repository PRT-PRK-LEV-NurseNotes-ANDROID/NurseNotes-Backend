package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.config.TestConfiguration;
import hu.unideb.nursenotes.service.imp.imp.ClientServiceImp;
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
public class _4ClientServiceFindTest {

    private static final String FIRSTNAME = "clientFirstName";

    private static final String LASTNAME = "clientLastName";

    private static final String ADDRESS = "clientAddress";

    private static final String PHONENUMBER = "clientPhoneNumber";

    private static final String SIGNATURE = "clientSignature";

    private static final int AGE = 50;

    private static final int WAGE = 200;

    @Autowired
    private ClientServiceImp clientService;

    private Client addedClient;

    @Before
    public void setUp() throws BaseException {

        User user = User.builder()
                .id(1L)
                .firstName("userFirstName")
                .lastName("userLastName")
                .username("userUsername")
                .password("userPassword")
                .email("userEmail")
                .createdDate(LocalDate.now())
                .build();

        Client client = Client.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .address(ADDRESS)
                .phoneNumber(PHONENUMBER)
                .age(AGE)
                .signature(SIGNATURE)
                .wage(WAGE)
                .user(user)
                .build();
        clientService.addClient(client);

        addedClient = Client.builder()
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
    }

    @Test
    public void findClientByIdTest() throws Exception {

        Client foundClient = clientService.findClientById(addedClient.getId());

        Assert.assertNotNull(foundClient);
        Assert.assertNotNull(foundClient.getId());
        Assert.assertNotNull(foundClient.getFirstName());
        Assert.assertNotNull(foundClient.getId());
        Assert.assertNotNull(foundClient.getFirstName());
        Assert.assertNotNull(foundClient.getLastName());
        Assert.assertNotNull(foundClient.getAddress());
        Assert.assertNotNull(foundClient.getPhoneNumber());
        Assert.assertNotNull(foundClient.getSignature());
        Assert.assertEquals("clientPhoneNumber", foundClient.getPhoneNumber());
        Assert.assertEquals("clientAddress",foundClient.getAddress());
        Assert.assertEquals(200,foundClient.getWage());
        Assert.assertEquals(50,foundClient.getAge());
    }
}

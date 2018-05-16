package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.commons.pojo.request.RegistrationRequest;
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
public class _3ClientServiceAddTest {

    private static final String FIRSTNAME = "clientFirstName";

    private static final String LASTNAME = "clientLastName";

    private static final String ADDRESS = "clientAddress";

    private static final String PHONENUMBER = "clientPhoneNumber";

    private static final String SIGNATURE = "clientSignature";

    private static final int AGE = 50;

    private static final int WAGE = 200;

    @Autowired
    private ClientServiceImp clientService;

    private Client client;

    private Client addedClient;

    @Before
    public void setUp() {

        User user = User.builder()
                .id(1L)
                .firstName("userFirstName")
                .lastName("userLastName")
                .username("userUsername")
                .password("userPassword")
                .email("userEmail")
                .createdDate(LocalDate.now())
                .build();

        client = Client.builder()
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .address(ADDRESS)
                .phoneNumber(PHONENUMBER)
                .age(AGE)
                .signature(SIGNATURE)
                .wage(WAGE)
                .user(user)
                .build();

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
    public void addClientTest() throws Exception {
        Assert.assertNotNull(clientService);

        Client addClient = clientService.addClient(client);

        Assert.assertNotNull(addClient.getId());
        Assert.assertNotNull(addClient.getFirstName());
        Assert.assertNotNull(addClient.getLastName());
        Assert.assertNotNull(addClient.getAddress());
        Assert.assertNotNull(addClient.getPhoneNumber());
        Assert.assertNotNull(addClient.getSignature());
        Assert.assertEquals("clientPhoneNumber", addClient.getPhoneNumber());
        Assert.assertEquals("clientAddress",addClient.getAddress());
        Assert.assertEquals(200,addClient.getWage());
        Assert.assertEquals(50,addClient.getAge());
        Assert.assertEquals(addClient,addedClient);
    }


}

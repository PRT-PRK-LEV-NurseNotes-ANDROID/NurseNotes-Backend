package hu.unideb.nursenotes.service.imp.test;


import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.config.TestConfiguration;
import hu.unideb.nursenotes.service.imp.imp.ClientServiceImp;
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
public class _5ClientServiceUpdateTest {

    private static final String FIRSTNAME = "clientFirstName";

    private static final String LASTNAME = "clientLastName";

    private static final String ADDRESS = "clientAddress";

    private static final String PHONENUMBER = "clientPhoneNumber";

    private static final String SIGNATURE = "clientSignature";

    private static final int AGE = 50;

    private static final int WAGE = 200;

    @Autowired
    private ClientServiceImp clientService;

    private Client updateClient;

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

        Client addedClient = Client.builder()
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

        updateClient = Client.builder()
                .id(addedClient.getId())
                .firstName(addedClient.getFirstName())
                .lastName(addedClient.getLastName())
                .address(addedClient.getAddress())
                .phoneNumber(addedClient.getPhoneNumber())
                .age(60)
                .signature(addedClient.getSignature())
                .wage(300)
                .user(addedClient.getUser())
                .build();

    }

    @Test
    public void updateClientTest() throws Exception {
        Assert.assertNotNull(clientService);

        Client updatedClient = clientService.updateClient(updateClient);

        Assert.assertNotNull(updatedClient.getFirstName());
        Assert.assertNotNull(updatedClient.getId());
        Assert.assertNotNull(updatedClient.getFirstName());
        Assert.assertNotNull(updatedClient.getLastName());
        Assert.assertNotNull(updatedClient.getAddress());
        Assert.assertNotNull(updatedClient.getPhoneNumber());
        Assert.assertNotNull(updatedClient.getSignature());
        Assert.assertEquals("clientPhoneNumber", updatedClient.getPhoneNumber());
        Assert.assertEquals("clientAddress", updatedClient.getAddress());
        Assert.assertEquals(300, updatedClient.getWage());
        Assert.assertEquals(60, updatedClient.getAge());
        Assert.assertEquals(updatedClient, updateClient);
    }

}

package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.domain.Client;
import hu.unideb.nursenotes.service.api.domain.User;
import hu.unideb.nursenotes.service.config.TestConfiguration;
import hu.unideb.nursenotes.service.imp.imp.ActivityServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class _8ActivityServiceGetTest {

    private static final Integer TRAVELTIME = 10;

    private static final String TIMESPENT = "10";

    private static final List<String> TYPE = new ArrayList<>();

    private static final LocalDate DATE = LocalDate.now();

    @Autowired
    private ActivityServiceImp activityServiceImp;

    private Client client;

    @Before
    public void setUp() throws Exception{

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
                .id(1L)
                .firstName("clientFName")
                .lastName("clientLName")
                .address("clientAddress")
                .phoneNumber("clientPhone")
                .age(50)
                .signature("Signature")
                .wage(200)
                .user(user)
                .build();

        TYPE.add("test1");
        TYPE.add("test2");
        TYPE.add("test3");

        Activity activityA = Activity.builder()
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .client(client)
                .build();
        activityServiceImp.addActivity(activityA);

        Activity addedA = Activity.builder()
                .id(1L)
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .client(client)
                .build();

        Activity activityB = Activity.builder()
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .client(client)
                .build();
        activityServiceImp.addActivity(activityB);

        Activity addedB = Activity.builder()
                .id(2L)
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .client(client)
                .build();
    }

    @Test
    public void getAllActivityByClientTest() throws Exception {

        List<ActivityResponse> clientsActivity = activityServiceImp.getAllActivityByClient(client);

        Assert.assertNotNull(clientsActivity);
        Assert.assertEquals(3,clientsActivity.size());
    }
}

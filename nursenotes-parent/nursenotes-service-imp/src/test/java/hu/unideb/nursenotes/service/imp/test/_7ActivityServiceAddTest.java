package hu.unideb.nursenotes.service.imp.test;

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
public class _7ActivityServiceAddTest {

    private static final Integer TRAVELTIME = 10;

    private static final String TIMESPENT = "10";

    private static final List<String> TYPE = new ArrayList<>();

    private static final LocalDate DATE = LocalDate.now();

    @Autowired
    private ActivityServiceImp activityServiceImp;

    private Activity activity;

    private Activity added;

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

        Client client = Client.builder()
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

        activity = Activity.builder()
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .client(client)
                .build();

        added = Activity.builder()
                .id(1L)
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .client(client)
                .build();
    }

    @Test
    public void addActivityTest() throws Exception {

        Activity addedActivity = activityServiceImp.addActivity(activity);

        Assert.assertNotNull(addedActivity);
        Assert.assertEquals(added,addedActivity);
    }

}

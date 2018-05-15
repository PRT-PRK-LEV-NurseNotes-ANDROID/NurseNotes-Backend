package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.config.TestConfiguration;
import hu.unideb.nursenotes.service.imp.imp.ActivityServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class ActivityServiceTest {

    private static final Integer TRAVELTIME = 10;

    private static final String TIMESPENT = "10";

    private static final String TYPE = "test";

    private static final LocalDate DATE = LocalDate.now();


    @Autowired
    private ActivityServiceImp activityServiceImp;

    private Activity activity;

    private Activity added;

    @Before
    public void setUp() {
        activity = Activity.builder()
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .build();

        added = Activity.builder()
                .id(1L)
                .travelTime(TRAVELTIME)
                .timeSpent(TIMESPENT)
                .type(TYPE)
                .date(DATE)
                .build();
    }

    @Test
    public void testAddActivityWithNoViolation() throws Exception {
//        Activity addedActivity = activityServiceImp.(activity);
//        Assert.assertThat(addedActivity, Matchers.is(added));
    }

}

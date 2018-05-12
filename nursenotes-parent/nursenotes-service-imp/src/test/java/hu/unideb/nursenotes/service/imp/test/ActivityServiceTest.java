package hu.unideb.nursenotes.service.imp.test;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.persistence.entity.ActivityEntity;
import hu.unideb.nursenotes.persistence.repository.ActivityRepository;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.imp.imp.ActivityServiceImp;
import hu.unideb.nursenotes.service.imp.validator.ActivityValidator;
import org.aopalliance.intercept.Invocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    @Spy
    @InjectMocks
    private ActivityServiceImp activityServiceImp;

    @Mock
    private ConversionService conversionService;

    @Mock
    private ActivityValidator activityValidator;

    @Before
    public void initMocks() throws BaseException {
        MockitoAnnotations.initMocks(this);

        Mockito.when(activityRepository.save(Mockito.any(ActivityEntity.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((ActivityEntity) args[0]).getId() == null) {
                        ((ActivityEntity) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.doNothing().when(activityValidator).validate(Mockito.any(Activity.class));
        Mockito.when(conversionService.convert(Mockito.any(Activity.class), ActivityEntity.class)).thenReturn(Mockito.any(ActivityEntity.class));
        Mockito.when(conversionService.convert(Mockito.any(ActivityEntity.class),Activity.class)).thenReturn(Mockito.any(Activity.class));
        Mockito.doThrow(ValidationException.class).when(conversionService.convert(Mockito.any(Activity.class), ActivityEntity.class));
    }



//    @Test
    public void createActivityTest(){
        Assert.assertNotNull(activityRepository);

        Activity activity = new Activity();
        activity.setDate(LocalDate.now());
        activity.setTimeSpent("20");
        activity.setType("Shopping");
        activity.setTravelTime(LocalDateTime.now());

        try {
            Activity saveActivity = activityServiceImp.addActivity(activity);
            Assert.assertNotNull(saveActivity);
            Assert.assertNotNull(saveActivity.getId());
            Assert.assertNotNull(saveActivity.getType());
            Assert.assertNotNull(saveActivity.getDate());
            Assert.assertNotNull(saveActivity.getTimeSpent());
            Assert.assertNotNull(saveActivity.getTravelTime());
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }
}

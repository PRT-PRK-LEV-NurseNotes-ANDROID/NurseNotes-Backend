package hu.unideb.nursenotes.backend.rest;

import hu.unideb.nursenotes.commons.pojo.exceptions.BaseException;
import hu.unideb.nursenotes.service.api.domain.Activity;
import hu.unideb.nursenotes.service.api.exception.ServiceException;
import hu.unideb.nursenotes.service.api.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static path.activity.ActivityPath.ACTIVITY_PATH;

/**
 * Class for activity rest point.
 */
@RestController
public class ActivityRestController {

    /**
     * Activity service.
     */
    @Autowired
    private ActivityService activityService;

    /**
     * @param activity is the activity.
     * @return a response.
     * @throws BaseException is the exception.
     */
    @RequestMapping(path = ACTIVITY_PATH, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public final ResponseEntity addActivity(@RequestBody
                                final Activity activity)
            throws BaseException {
        ResponseEntity responseEntity;

        try {
            activityService.addActivity(activity);
            responseEntity = ResponseEntity.accepted()
                    .body("Successful activity creation");
        } catch (ServiceException e) {
            responseEntity = ResponseEntity.status(HttpStatus
                    .INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
        return responseEntity;
    }
}

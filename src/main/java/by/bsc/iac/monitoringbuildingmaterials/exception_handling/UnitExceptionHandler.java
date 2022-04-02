package by.bsc.iac.monitoringbuildingmaterials.exception_handling;

import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;
import by.bsc.iac.monitoringbuildingmaterials.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UnitExceptionHandler {

    public static final String DEFAULT_ERROR_PAGE = "404";
/*
    @ExceptionHandler
    public ResponseEntity<UnitIncorrectData> handleException(NoSuchUnitException exception) {
        UnitIncorrectData data = new UnitIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UnitIncorrectData> handleException(Exception exception) {
        UnitIncorrectData data = new UnitIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
*/


    // catch any exceptions
    @ExceptionHandler()
//    @ExceptionHandler(Exception.class)
    public ModelAndView handleDefaultException(HttpServletRequest request, Exception e){
//        ResponseMessage responseMessage = new ResponseMessage(e.getMessage());
/*        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;*/
        ModelAndView model = new ModelAndView();
        model.addObject("exception", e);
        model.addObject("url", request.getRequestURL());
        model.setViewName(DEFAULT_ERROR_PAGE);
        return model;
    }
}

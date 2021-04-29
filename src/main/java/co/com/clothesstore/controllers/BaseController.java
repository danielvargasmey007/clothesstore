package co.com.clothesstore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.com.clothesstore.models.Status;

/**
 * The Class BaseController.
 */
@RestControllerAdvice
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH,
        RequestMethod.TRACE }, allowedHeaders = "*")
public class BaseController {

    /**
     * Manage error.
     *
     * @param e the e
     * @return the object
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public Object manageError(Throwable e) {
        Status status = new Status();
        status.setMessage("!Oops, An error has occurred, please contact the support team!");
        status.setResponse("ERROR");
        return status;
    }

}

package web.model.exceptions;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
public class WrongPasswordException extends MyException{

    public WrongPasswordException(String msg) {
        super(msg);
    }
}

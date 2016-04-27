package com.newnius.util;

/**
 *
 * extends CRObject, often used in socket connection to exchange message
 *
 * @author Newnius
 * @version 0.1.0(General)
 * Dependencies
 *  com.newnius.util.CRObject
 *  
 * @// FIXME: 16-4-27  unable to add list
 */
public class CRMsg extends CRObject{
    private int errno = 0;
    private String message = "";

    public CRMsg(int errno){
        super();
        this.errno = errno;
    }

    public CRMsg(int errno, String message){
        super();
        this.errno = errno;
        this.message = message;
    }

    public int getErrno() {
        return errno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

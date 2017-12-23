package com.ueeprototype.ueeprototype;

/**
 * Created by madupoorna on 12/20/17.
 */

public class EmailDataObject {

    private String email;
    private String date;

    public EmailDataObject(String email, String date) {
        this.email = email;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

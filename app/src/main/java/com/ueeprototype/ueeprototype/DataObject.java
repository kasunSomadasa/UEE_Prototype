package com.ueeprototype.ueeprototype;

/**
 * Created by madupoorna on 12/19/17.
 */

public class DataObject {

    private String name;
    private String mobileNo;
    private String email;

    DataObject (String Lname,String mobNo, String mail){
        name = Lname;
        mobileNo = mobNo;
        email= mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }
}

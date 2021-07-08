package com.android.uniinfo;

public class iUniversity {
    String universityName,city,country,webLink;

    public iUniversity(String gName,String gCity,String gCountry,String gWebLink){
        universityName = gName;
        city = gCity;
        country = gCountry;
        webLink = gWebLink;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getWebLink() {
        return webLink;
    }
}

package com.skyroof.model;

public class MyResponse {
    //fields xwris classifier einai accesible se olo to package
    //to pio swsto einai na ta kanoyme private
    String responseCode;
    String responseDescription;
    AgeType ageType;

    public MyResponse(String responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public AgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(AgeType ageType) {
        this.ageType = ageType;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseDescription='" + responseDescription + '\'' +
                ", ageType=" + ageType +
                '}';
    }
}

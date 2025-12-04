package dto;

import com.google.gson.annotations.SerializedName;

public class CardDetails {

    @SerializedName("Name")
    private String name;

    @SerializedName("Number")
    private String number;

    @SerializedName("Month")
    private String month;

    @SerializedName("Year")
    private String year;

    @SerializedName("code")
    private String code;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

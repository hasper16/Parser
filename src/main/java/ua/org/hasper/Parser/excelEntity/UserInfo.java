package ua.org.hasper.Parser.excelEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfo implements ExcelEntity {
    @JsonIgnore
    private String rowNum;
    private String id;
    private String userName;
    private String birthday;
    private String email;
    private String gender;
    private String location;
    private String phone;

    public UserInfo(String rowNum, String id, String userName, String birthday, String email, String gender, String location, String phone) {
        this.rowNum = rowNum;
        this.id = id;
        this.userName = userName;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.location = location;
        this.phone = phone;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

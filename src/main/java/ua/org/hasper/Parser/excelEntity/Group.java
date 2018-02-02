package ua.org.hasper.Parser.excelEntity;

public class Group implements ExcelEntity {
    private String rowNum;
    private String type;
    private String id;
    private String name;
    private String members;
    private String webSite;
    private String address;
    private String email;
    private String phone;

    public Group(String rowNum, String type, String id, String name, String members, String webSite, String address, String email, String phone) {
        this.rowNum = rowNum;
        this.type = type;
        this.id = id;
        this.name = name;
        this.members = members;
        this.webSite = webSite;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

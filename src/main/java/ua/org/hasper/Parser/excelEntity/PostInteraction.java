package ua.org.hasper.Parser.excelEntity;

public class PostInteraction implements ExcelEntity {
    private String rowNum;
    private String postId;
    private String userid;
    private String name;

    public PostInteraction(String rowNum, String postId, String userid, String name) {
        this.rowNum = rowNum;
        this.postId = postId;
        this.userid = userid;
        this.name = name;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return getUserid();
    }
}

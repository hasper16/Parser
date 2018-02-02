package ua.org.hasper.Parser.excelEntity;

public class Post implements ExcelEntity {
    private String rowNum;
    private String id;
    private String content;
    private String likes;
    private String shares;
    private String coments;

    public Post(String rowNum, String id, String content, String likes, String shares, String coments) {
        this.rowNum = rowNum;
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.shares = shares;
        this.coments = coments;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }
}

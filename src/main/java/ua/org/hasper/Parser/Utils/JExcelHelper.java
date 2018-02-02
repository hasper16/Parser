package ua.org.hasper.Parser.Utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.org.hasper.Parser.excelEntity.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JExcelHelper {
    private static final Logger log = LoggerFactory.getLogger(JSONHelper.class);
    private File txtFile;

    public JExcelHelper(File xlsx) {
        ClassLoader classLoader = getClass().getClassLoader();
        File folder = null;
        if (classLoader.getResource("files") == null) {
            folder = new File("files");
            folder.mkdir();
        }

        String path = classLoader.getResource("files") == null ? folder.getPath() : classLoader.getResource("files").getPath();
        path += "/" + FilenameUtils.getName(xlsx.getName()).replace(FilenameUtils.getExtension(xlsx.getName()), "txt");
        txtFile = new File(path);
    }

    public File getGroupsTxtRes(File xlsxFile) throws IOException {
        return createNewTXTResult(getGroups(xlsxFile));
    }

    public File getPagesTxtRes(File xlsxFile) throws IOException {
        return createNewTXTResult(getPages(xlsxFile));
    }

    public File getGroupMembersTxtRes(File xlsxFile) throws IOException {
        return createNewTXTResult(getGroupMembers(xlsxFile));
    }

    public File getPostsTxtRes(File xlsxFile) throws IOException {


        return createNewTXTResult(getPosts(xlsxFile));
    }

    public File getPostInteractionsTxtRes(File xlsxFile) throws IOException {
        return createNewTXTResult(getPostInteractions(xlsxFile));
    }

    public File getUserInfoTxtRes(File xlsxFile) throws IOException {
        return createNewTXTResult(getUserInfo(xlsxFile));
    }

    public List<UserInfo> getUserInfo(File xlsxFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(xlsxFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<UserInfo> userInfos = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            try {
                if (i > 0) {
                    String rowNum = row.getCell(0).toString();
                    String id = row.getCell(1).toString();
                    String name = row.getCell(2).toString();
                    String birthday = row.getCell(3).toString();
                    String email = row.getCell(4).toString();
                    String gender = row.getCell(5).toString();
                    String location = row.getCell(6).toString();
                    String phone = row.getCell(7).toString();
                    if (id != null || id != "") {
                        UserInfo userInfo = new UserInfo(rowNum, id, name, birthday, email, gender, location, phone);
                        userInfos.add(userInfo);
                    }
                } else if (i == 0) {
                    if (row.getCell(1).toString() != "" && !row.getCell(1).toString().toLowerCase().contains("id")) {
                        return null;
                    }
                }
                i++;
            } catch (NullPointerException e) {
                log.info("File: " + xlsxFile.getName() + " // ignore rownum = " + i);
            }
        }
        if (userInfos.size() == 0) {
            return null;
        }

        return userInfos;
    }

    public List<Group> getGroups(File xlsxFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(xlsxFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Group> groups = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            try {
                if (i > 0) {
                    String rowNum = row.getCell(0).toString();
                    String type = row.getCell(1).toString();
                    String id = row.getCell(2).toString();
                    String name = row.getCell(3).toString();
                    String members = row.getCell(4).toString();
                    String webSite = row.getCell(5).toString();
                    String address = row.getCell(6).toString();
                    String email = row.getCell(7).toString();
                    String phone = row.getCell(8).toString();
                    if (id != null || id != "") {
                        Group group = new Group(rowNum, type, id, name, members, webSite, address, email, phone);
                        groups.add(group);
                    }
                } else if (i == 0) {
                    if (row.getCell(2).toString() != "" && !row.getCell(2).toString().toLowerCase().contains("id")) {
                        return null;
                    }
                }
            } catch (NullPointerException e) {
                log.info("File: " + xlsxFile.getName() + " // ignore rownum = " + i);
            }
            i++;

        }
        if (groups.size() == 0) {
            return null;
        }
        return groups;
    }

    public List<Page> getPages(File xlsxFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(xlsxFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Page> pages = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            try {
                if (i > 0) {
                    String rowNum = row.getCell(0).toString();
                    String type = row.getCell(1).toString();
                    String id = row.getCell(2).toString();
                    String name = row.getCell(3).toString();
                    String members = row.getCell(4).toString();
                    String webSite = row.getCell(5).toString();
                    String address = row.getCell(6).toString();
                    String email = row.getCell(7).toString();
                    String phone = row.getCell(8).toString();
                    if (id != null || id != "") {
                        Page page = new Page(rowNum, type, id, name, members, webSite, address, email, phone);
                        pages.add(page);
                    }
                } else if (i == 0) {
                    if (row.getCell(2).toString() != "" && !row.getCell(2).toString().toLowerCase().contains("id")) {
                        return null;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("ignore row = " + i);
            }
            i++;
        }
        if (pages.size() == 0) {
            return null;
        }
        return pages;
    }

    public List<GroupMember> getGroupMembers(File xlsxFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(xlsxFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<GroupMember> groupMembers = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            try {
                if (i > 0) {
                    String rowNum = row.getCell(0).toString();
                    String id = row.getCell(1).toString();
                    String name = row.getCell(2).toString();
                    String gender = row.getCell(3).toString();
                    String birthday = row.getCell(4).toString();
                    String email = row.getCell(5).toString();
                    String phone = row.getCell(6).toString();
                    String location = row.getCell(7).toString();
                    if (id != null || id != "") {
                        GroupMember groupMember = new GroupMember(rowNum, id, name, gender, birthday, email, phone, location);
                        groupMembers.add(groupMember);
                    }
                } else if (i == 0) {
                    if (row.getCell(1).toString() != "" && !row.getCell(1).toString().toLowerCase().contains("id")) {
                        return null;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("ignore row = " + i);
            }
            i++;
        }
        if (groupMembers.size() == 0) {
            return null;
        }
        return groupMembers;
    }

    public List<Post> getPosts(File xlsxFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(xlsxFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Post> posts = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            try {
                if (i > 0) {
                    String rowNum = row.getCell(0).toString();
                    String id = row.getCell(1).toString();
                    String content = row.getCell(2).toString();
                    String likes = row.getCell(3).toString();
                    String shares = row.getCell(4).toString();
                    String coments = row.getCell(5).toString();
                    if (id != null || id != "") {
                        Post post = new Post(rowNum, id, content, likes, shares, coments);
                        posts.add(post);
                    }
                } else if (i == 0) {
                    if (row.getCell(1).toString() != "" && !row.getCell(1).toString().toLowerCase().contains("id")) {
                        return null;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("ignore row = " + i);
            }
            i++;
        }
        if (posts.size() == 0) {
            return null;
        }
        return posts;
    }

    public List<PostInteraction> getPostInteractions(File xlsxFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(xlsxFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<PostInteraction> postInteractions = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            try {
                if (i > 0) {
                    String rowNum = row.getCell(0).toString();
                    String id = row.getCell(1).toString();
                    String userId = row.getCell(2).toString();
                    String name = row.getCell(3).toString();
                    if (id != null || id != "") {
                        PostInteraction postInteraction = new PostInteraction(rowNum, id, userId, name);
                        postInteractions.add(postInteraction);
                    }
                } else if (i == 0) {
                    if (row.getCell(1).toString() != "" && !row.getCell(1).toString().toLowerCase().contains("id")) {
                        return null;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("ignore row = " + i);
            }
            i++;
        }
        if (postInteractions.size() == 0) {
            return null;
        }
        return postInteractions;
    }

    private File createNewTXTResult(List<? extends ExcelEntity> list) throws IOException {
        FileWriter fileWriter = new FileWriter(txtFile);

        for (ExcelEntity g :
                list) {
            fileWriter.write(g.getId());
            fileWriter.append(System.lineSeparator());
        }
        fileWriter.flush();
        fileWriter.close();

        return txtFile;
    }

    public boolean dropTxtFile() {
        return txtFile.delete();
    }

    public File getTxtFile() {
        return txtFile;
    }

    public void setTxtFile(File txtFile) {
        this.txtFile = txtFile;
    }
}

package ua.org.hasper.Parser.controllers;


import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.org.hasper.Parser.Utils.FileReader;
import ua.org.hasper.Parser.Utils.JExcelHelper;
import ua.org.hasper.Parser.Utils.JSONHelper;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class FileController {


    @PostMapping("/stepOne")
    public String stepOne(Model model, HttpServletResponse response, MultipartFile file,
                          @RequestParam(value = "radioStepOne") String radioStep) {
        try {
            FileReader fileReader = new FileReader(file);
            JExcelHelper jExcelHelper = new JExcelHelper(fileReader.getFile());
            InputStream inputStream;
            if (radioStep.equals("Group")) {
                inputStream = new FileInputStream(jExcelHelper.getGroupsTxtRes(fileReader.getFile()));
                fileReader.dropFile();
            } else if (radioStep.equals("Page")) {
                inputStream = new FileInputStream(jExcelHelper.getPagesTxtRes(fileReader.getFile()));
                fileReader.dropFile();
            } else {
                fileReader.dropFile();
                model.addAttribute("message", "File type is not selected");
                return "index";
            }
            getFileForDownload(response, inputStream, jExcelHelper.getTxtFile());
            jExcelHelper.dropTxtFile();
            return null;
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                model.addAttribute("message", "Invalid file format");
            } else {
                model.addAttribute("message", e.toString());
            }
        }

        return "index";
    }

    @RequestMapping("/stepTwo")
    public String stepTwo(Model model, HttpServletResponse response, MultipartFile file) {
        try {
            FileReader fileReader = new FileReader(file);
            JExcelHelper jExcelHelper = new JExcelHelper(fileReader.getFile());
            InputStream inputStream;

            inputStream = new FileInputStream(jExcelHelper.getGroupMembersTxtRes(fileReader.getFile()));
            fileReader.dropFile();

            getFileForDownload(response, inputStream, jExcelHelper.getTxtFile());
            jExcelHelper.dropTxtFile();
            return null;
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                model.addAttribute("message", "Invalid file format");
            } else {
                model.addAttribute("message", e.toString());
            }
        }
        return "index";
    }

    @PostMapping("/stepThree")
    public String stepThree(Model model, HttpServletResponse response, MultipartFile file) {
        try {
            FileReader fileReader = new FileReader(file);
            JExcelHelper jExcelHelper = new JExcelHelper(fileReader.getFile());
            InputStream inputStream;

            inputStream = new FileInputStream(jExcelHelper.getPostsTxtRes(fileReader.getFile()));
            fileReader.dropFile();

            getFileForDownload(response, inputStream, jExcelHelper.getTxtFile());
            jExcelHelper.dropTxtFile();
            return null;
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                model.addAttribute("message", "Invalid file format");
            } else {
                model.addAttribute("message", e.toString());
            }
        }
        return "index";
    }

    @PostMapping("/stepFour")
    public String stepFour(Model model, HttpServletResponse response, MultipartFile file) {
        try {
            FileReader fileReader = new FileReader(file);
            JExcelHelper jExcelHelper = new JExcelHelper(fileReader.getFile());
            InputStream inputStream;

            inputStream = new FileInputStream(jExcelHelper.getPostInteractionsTxtRes(fileReader.getFile()));
            fileReader.dropFile();

            getFileForDownload(response, inputStream, jExcelHelper.getTxtFile());
            jExcelHelper.dropTxtFile();
            return null;
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                model.addAttribute("message", "Invalid file format");
            } else {
                model.addAttribute("message", e.toString());
            }
        }
        return "index";
    }

    @PostMapping("/stepFive")
    public String stepFive(Model model, HttpServletResponse response, MultipartFile file) {
        try {
            FileReader fileReader = new FileReader(file);
            JExcelHelper jExcelHelper = new JExcelHelper(fileReader.getFile());
            InputStream inputStream;

            inputStream = new FileInputStream(jExcelHelper.getUserInfoTxtRes(fileReader.getFile()));
            fileReader.dropFile();

            getFileForDownload(response, inputStream, jExcelHelper.getTxtFile());
            jExcelHelper.dropTxtFile();
            return null;
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                model.addAttribute("message", "Invalid file format");
            } else {
                model.addAttribute("message", e.toString());
            }
        }
        return "index";
    }

    @PostMapping("/stepSix")
    public String stepSix(Model model, HttpServletResponse response, MultipartFile file) {
        try {
            FileReader fileReader = new FileReader(file);
            JExcelHelper jExcelHelper = new JExcelHelper(fileReader.getFile());
            JSONHelper jsonHelper = new JSONHelper();
            InputStream inputStream;

            inputStream = new FileInputStream(jsonHelper.getUserInfosJSONFile(jExcelHelper.getUserInfo(fileReader.getFile())));
            fileReader.dropFile();

            getFileForDownload(response, inputStream, jsonHelper.getFile());
            jExcelHelper.dropTxtFile();
            jsonHelper.dropJSONFile();
            return null;
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                model.addAttribute("message", "Invalid file format");
            } else {
                model.addAttribute("message", e.toString());
            }
        }
        return "index";
    }

    private void getFileForDownload(HttpServletResponse response, InputStream inputStream, File file) throws IOException {
        response.addHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.setContentType(FilenameUtils.getExtension(file.getName()));
        response.setContentLength((int) file.length());
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}

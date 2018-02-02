package ua.org.hasper.Parser.Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import ua.org.hasper.Parser.excelEntity.UserInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONHelper {
    ObjectMapper objectMapper;
    File file;

    public JSONHelper() {
        objectMapper = new ObjectMapper();
    }

    public File getUserInfosJSONFile(List<UserInfo> userInfos) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File folder = null;
        if (classLoader.getResource("files") == null) {
            folder = new File("files");
            folder.mkdir();
        }

        String path = classLoader.getResource("files") == null ? folder.getPath() : classLoader.getResource("files").getPath();
        path += "/" + "UserInfo.json";
        file = new File(path);
        objectMapper.writeValue(file, userInfos);
        return file;
    }

    public boolean dropJSONFile() {
        return file.delete();
    }

    public File getFile() {
        return file;
    }
}

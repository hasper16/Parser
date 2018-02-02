package ua.org.hasper.Parser.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {
    private File file;

    public FileReader(MultipartFile file) throws IOException {
        InputStream in = file.getInputStream();
        ClassLoader classLoader = getClass().getClassLoader();
        File folder = null;
        if (classLoader.getResource("files") == null) {
            folder = new File("files");
            folder.mkdir();
        }

        String path = classLoader.getResource("files") == null ? folder.getPath() : classLoader.getResource("files").getPath();
        path += "/" + file.getOriginalFilename();
        this.file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        int ch = 0;
        while ((ch = in.read()) != -1) {
            fileOutputStream.write(ch);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean dropFile() {
        return file.delete();
    }
}

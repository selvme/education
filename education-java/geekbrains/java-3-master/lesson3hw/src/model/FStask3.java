package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FStask3 {
    private final Path path;
    private List<String> pages;
    private int countPage;

    public FStask3(String path) {
        this.path = Paths.get(path);
        try {
            init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void init() throws FileNotFoundException {
        long size = 0;
        BufferedReader reader = null;
        char[] chars = new char[1800];
        if (Files.notExists(path)) {
            throw new FileNotFoundException("No such file exists");
        }
        try {
            reader = Files.newBufferedReader(path);
            size = Files.size(path);
            countPage = (int) Math.ceil(size / 1800);
            pages = new ArrayList<>(countPage);
            int flag;
            while ((flag = reader.read(chars)) != -1) {
                pages.add(new String(chars));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readPage(int numberPage) {
        return pages.get(numberPage);
    }
}

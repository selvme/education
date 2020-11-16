package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public final class FStask1 {
    private final Path path;

    public FStask1(String path) {
        this.path = Paths.get(path);
        init();
    }

    public void readToConsole() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            Random random = new Random();
            OutputStream outputStream = null;
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                outputStream = Files.newOutputStream(path);
                for (int i = 0; i < 50; i++) {
                    outputStream.write(random.nextInt(95) + 32); // Write from 32(Space) to 126(~) chars
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

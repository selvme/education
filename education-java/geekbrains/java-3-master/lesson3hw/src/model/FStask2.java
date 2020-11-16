package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FStask2 {
    private List<InputStream> inputStreams;

    public FStask2() {
        this.inputStreams = new ArrayList<>();
    }

    public void addFile(String path) {
        Path p = Paths.get(path);
        checkPath(p, true);
        try {
            inputStreams.add(Files.newInputStream(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkPath(Path path, boolean fill) {
        if (!Files.exists(path)) {
            OutputStream outputStream = null;
            Random random = new Random();
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                if (fill) {
                    outputStream = Files.newOutputStream(path);
                    for (int i = 0; i < 100; i++) {
                        outputStream.write(random.nextInt(95) + 32); // Write from 32(Space) to 126(~) chars
                    }
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

    public void mergeFiles(String toFile) throws IOException {
        Path p = Paths.get(toFile);
        checkPath(p, false);
        Enumeration<InputStream> e = Collections.enumeration(inputStreams);
        SequenceInputStream inputStream = new SequenceInputStream(e);
        OutputStream outputStream = Files.newOutputStream(p);
        int c;
        while ((c = inputStream.read()) != -1) {
            outputStream.write(c);
        }
    }
}

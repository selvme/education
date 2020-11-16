package task2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Writer {
    private final Path PATH = Paths.get(".\\resources\\file.txt");

    void writeInFile(String string) {
        if (checkFile(PATH)) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(PATH)) {
                while (true) {
                    if (Files.isWritable(PATH)) {
                        bufferedWriter.append(string);
//                        bufferedWriter.write(string);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkFile(Path path) {
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}

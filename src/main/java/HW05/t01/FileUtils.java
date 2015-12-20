package HW05.t01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {
    static Path currentPath;

    public static void showDirectory() {
        showDirectory(currentPath.toString());
    }

    public static void showDirectory(String dir) {

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path entry : directoryStream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
        }
    }

    public static void changeDir(String dir) throws FileNotFoundException, NotADirectoryException {
        if (dir.equals("..")) {
            currentPath = Paths.get(String.valueOf(currentPath.getParent()));
        } else {
            File file = new File(String.valueOf(currentPath) + "\\" + Paths.get(dir));
            if (file.exists() && file.isDirectory())
                currentPath = Paths.get(currentPath.toString() + "\\" + Paths.get(dir).toString());
            else {
                if (!file.exists()) throw new FileNotFoundException("such directory does not exist");
                else throw new NotADirectoryException();
            }
        }
    }

    public static void createFile(String fName) throws NotTxtFileException {
        if (!fName.endsWith(".txt")) {
            throw new NotTxtFileException();
        }
        File file = new File(String.valueOf(currentPath) + "\\" + fName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void removeFile(String fName) {
        new File(String.valueOf(currentPath) + "\\" + fName).delete();
    }

    public static void writeText(String fName) throws NotTxtFileException {
        if (!fName.endsWith(".txt")) {
            throw new NotTxtFileException();
        }
        System.out.println("Enter new text:\n\r");
        String text = FileBrowser.SCANNER.nextLine();
        try (FileWriter fw = new FileWriter(new File(String.valueOf(currentPath) + "\\" + fName), true)) {
            fw.append(text);
            fw.flush();
        } catch (IOException e) {
            System.err.println("    Cинтаксическая ошибка в имени файла, имени папки или метке тома");
        }
    }
}

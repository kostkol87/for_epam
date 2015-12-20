package HW05.t01;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

import static HW05.t01.FileUtils.*;

/**
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой
 * системы, а также создавать и удалять текстовые файлы. Для работы с текстовыми файлами
 * необходимо реализовать функциональность записи (дозаписи) в файл. Требуется определить
 * исключения для каждого слоя приложения и корректно их обработать.
 */
public class FileBrowser {
    FileBrowser(){
        FileUtils.currentPath = Paths.get(System.getProperty("user.dir"));
    }
    public static final Scanner SCANNER = new Scanner(System.in);

    public void getCmd() {
        System.out.print(FileUtils.currentPath + ">>>");
        String input = FileBrowser.SCANNER.nextLine();
        String[] inputs = input.split(" ", 2);
        String cmd = inputs[0];
        String arg;
        try {
            arg = inputs[1];
        }catch (ArrayIndexOutOfBoundsException e){
            arg = "";
        }
        cmd(cmd, arg);
    }

    public void cmd(String cmd, String arg) {
        switch (cmd){

            case "dir":{
                if(arg.isEmpty()){
                    showDirectory();
                }else {
                    showDirectory(arg);
                }
                break;

            }case "cd":{
                try {
                    changeDir(arg);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (NotADirectoryException e) {
                    System.out.println(e.getMessage());
                }
                break;

            }case "touch":{
                try {
                    createFile(arg);
                } catch (NotTxtFileException e) {
                    System.out.println(e.getMessage());
                }
                break;

            }case "rm":{
                removeFile(arg);
                break;

            }case "write":{
                try {
                    writeText(arg);
                } catch (NotTxtFileException e) {
                    System.out.println(e.getMessage());
                }
                break;

            }default:
                System.out.println("    help: dir - show directory." +
                        "\r\n   cd - move into directory." +
                        "\r\n   touch - create text - file." +
                        "\r\n   rm - remove text - file." +
                        "\r\n   write - write text to file");
        }
        getCmd();
    }

}

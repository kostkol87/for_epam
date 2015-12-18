package HW04.t03;

import java.io.*;

/**
 * Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8. Прочитайте
 * информацию из файла и перепишите ее в файл в кодировкой utf-16.
 */
public class DecodingBytes {

    public String readFileU8(String path) throws IOException {
        try(FileInputStream fis = new FileInputStream(path)){
            StringBuilder contentU8 = new StringBuilder();
            byte[] tmp = new byte[64];
            while ((fis.read(tmp)) != -1){
                contentU8.append(new String(tmp, "cp1251"));
            }
            return contentU8.toString();
        }
    }

    public void rewriteFileU15(String path, String text) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(path)){
            fos.write(new String(text.getBytes(), "utf-16").getBytes());
        }
    }

}

package HW05.t01;

import java.io.IOException;

/**
 * Created by Konstantin on 20.12.2015.
 */
public class NotTxtFileException extends IOException {
    public NotTxtFileException() {
        super("It allows to change only *.txt files!");
    }
}

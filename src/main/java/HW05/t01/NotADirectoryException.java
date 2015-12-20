package HW05.t01;

import java.io.IOException;

public class NotADirectoryException extends IOException{
    public NotADirectoryException() {
        super("not a directory!");
    }
}

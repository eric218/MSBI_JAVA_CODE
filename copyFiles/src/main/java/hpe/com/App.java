package hpe.com;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        CopyFiles.copy();
        System.out.println("copy files successful");
    }
}

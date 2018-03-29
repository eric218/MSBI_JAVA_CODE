package hpe.com;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Wang,Wei
 * Date: 2018-03-29
 * Time: 2:56 PM
 */
public class AppNon {
    public static void main( String[] args ) throws IOException {
        CopyFiles.copyNonProd();
        System.out.println("copy non prod files successful");
    }
}

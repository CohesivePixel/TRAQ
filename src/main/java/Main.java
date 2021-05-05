import service.Local;
import util.Tag;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Tag crawler = new Tag();
        ArrayList<Local> newFiles = (crawler.getNewFiles(
                new File("/home/ben/Projects/_Native/TRAQ 2.0/2-Back End/src/test/resources/Music/_Use/")));

        newFiles.forEach((n) -> System.out.println(n.getName() + " | by: " + n.getAuthor()));

    }
}

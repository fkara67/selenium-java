package selenium_intro.ExelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
    public static void main(String[] args) throws IOException {
        dataDriven d = new dataDriven();

        ArrayList<String> data = d.getData("Add Profile");

        for (String datum : data) {
            System.out.println(datum);
        }
    }
}

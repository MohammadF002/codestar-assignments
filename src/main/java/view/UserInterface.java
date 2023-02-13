package view;




import model.InvertedIndex;
import model.query.ComplexQuery;

import java.util.*;

public class UserInterface {

    public void run(InvertedIndex invertedIndex) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter phrase(\"end\" to finish the program):");
        String input = myScanner.nextLine();
        while (!input.equals("end")) {
            ComplexQuery query = new ComplexQuery(input, invertedIndex);
            for (String s : query.sendQueryResponse())
                System.out.printf("%-10s",s);
            System.out.println("\nEnter phrase(\"end\" to finish the program):");
            input = myScanner.nextLine();
        }
        myScanner.close();
    }

}

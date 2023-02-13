package view;




import model.InvertedIndex;
import model.query.ComplexQuery;
import model.query.ComplexQueryDecoder;

import java.util.*;

public class UserInterface {

    public void run(InvertedIndex invertedIndex) {
        final String enterPhrase = "Enter phrase(\"end\" to finish the program):";
        Scanner myScanner = new Scanner(System.in);
        System.out.println(enterPhrase);
        String input = myScanner.nextLine();
        while (!input.equals("end")) {
            ComplexQuery query = new ComplexQuery(input, invertedIndex, new ComplexQueryDecoder());
            for (String s : query.sendQueryResponse())
                System.out.print(s + "\t");
            System.out.println(enterPhrase);
            input = myScanner.nextLine();
        }
        myScanner.close();
    }

}

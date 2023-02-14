package view;




import model.InvertedIndex;
import model.query.ComplexQuery;
import model.query.ComplexQueryDecoder;
import model.query.ComplexQueryResponseGenerator;

import java.util.*;

public class UserInterface {
    private static final String END = "end";
    private static final String ENTER_PHRASE = "Enter phrase(\"end\" to finish the program):";
    public void run(InvertedIndex invertedIndex) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(ENTER_PHRASE);
        String input = myScanner.nextLine();

        while (!input.equals(END)) {
            ComplexQuery query = new ComplexQuery(input, invertedIndex, new ComplexQueryDecoder(),
                    new ComplexQueryResponseGenerator());
            for (String s : query.sendQueryResponse())
                System.out.print(s + "\t");
            System.out.println("\n" + ENTER_PHRASE);
            input = myScanner.nextLine();
        }
        myScanner.close();
    }

}

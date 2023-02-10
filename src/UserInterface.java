package src;


import java.util.*;

public class UserInterface {

    public void run(InvertedIndex invertedIndex) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter phrase(enter \"end\" to finish the program):");
        String input = myScanner.nextLine();
        while (!input.equals("end")) {
            var sets = inputDecoder(input);
            var out = extractWordsFromInvertedIndex(invertedIndex, sets);
            for (String s : out)
                System.out.printf("%-10s",s);
            System.out.println("\nEnter phrase(enter \"end\" to finish the program):");
            input = myScanner.nextLine();
        }
        myScanner.close();
    }

    public HashMap<String,Set<String>> inputDecoder (String rawInput) {
        HashMap<String,Set<String>> result = new HashMap<>() {{
            put("union",new HashSet<>());
            put("difference",new HashSet<>());
            put("normal", new HashSet<>());
        }};
        String[] args = rawInput.split(" ");
        for (String arg : args) {
            if (arg.startsWith("+"))
                result.get("union").add(arg.substring(1));
            else if (arg.startsWith("-"))
                result.get("difference").add(arg.substring(1));
            else
                result.get("normal").add(arg);
        }
        return result;
    }

    public List<String> extractWordsFromInvertedIndex (InvertedIndex invertedIndex, HashMap<String,Set<String>> sets) {
        List<String> result = new ArrayList<>();
        SetOperations setOperator = new SetOperations();
        result.addAll(setOperator.union(invertedIndex.extractWordsFromInvertedIndex(sets.get("union"))));
        result.retainAll(setOperator.intersection(invertedIndex.extractWordsFromInvertedIndex(sets.get("normal"))));
        result.removeAll(setOperator.union(invertedIndex.extractWordsFromInvertedIndex(sets.get("difference"))));
        return result;
    }
}

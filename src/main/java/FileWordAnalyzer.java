import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    public static void main(String[] args) {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.getWordsOrderedAlphabetically();
        fileWordAnalyzer.getWordsContainingSubstring("d");
        fileWordAnalyzer.getStringsWhichPalindromes();
    }

    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {
        filePartReader.setup(FilePartReader.poemFilePath, 1,10);
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically () {
        String[] wordArray = wordArray();
        //Arrays.stream(array).forEach(System.out::println);
        List<String> sortedArray = new ArrayList<>(Arrays.stream(wordArray).sorted().collect(Collectors.toList()));
        //sortedArray.forEach(s -> System.out.print("\""+s+"\","));
        return sortedArray;
    }

    public List<String> getWordsContainingSubstring (String subString ){
        String[] wordArray = wordArray();
        List<String> containsSubstring = new ArrayList<>();
        Arrays.stream(wordArray).forEach(s -> {
            if(s.toLowerCase().contains(subString.toLowerCase())) containsSubstring.add(s);
        });
        //containsSubstring.forEach(s -> System.out.print("\""+s+"\","));
        return containsSubstring;
    }

    public List<String> getStringsWhichPalindromes () {
        String[] wordArray = wordArray();
        List<String> palindromes = new ArrayList<>();
        Arrays.stream(wordArray).forEach(s -> {
            String backward = new StringBuilder(s).reverse().toString().toLowerCase();
            if (s.toLowerCase().equals(backward)) palindromes.add(s);
        });
        //palindromes.forEach(System.out::println);
        return palindromes;
    }

    private String[] wordArray () {
        String readLines = filePartReader.readLines ().replace("\n"," ").replaceAll("[.,;]", " ").replaceAll("  ", " ");
        return readLines.replaceAll("  ", " ").split(" ");
    }

}

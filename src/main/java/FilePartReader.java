import java.io.FileInputStream;
import java.util.Arrays;

public class FilePartReader {

    public static String poemFilePath = "/home/dszendrei/codecool/oop/si5/filepartreader-testing-with-junit-dszendrei/src/Dylan Thomas - Do not go gentle into that good night.txt";

    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(poemFilePath, 1,8);
        System.out.println(filePartReader.readLines());
    }

    private String filePath;
    private int fromLine;
    private int toLine;

    FilePartReader() {
        filePath = "/";
        fromLine = 1;
        toLine = 1;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine must be greater or equal fromLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine must be greater than 0");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read(){
        try {
            FileInputStream fis = new FileInputStream(filePath);
            int i;
            StringBuilder result = new StringBuilder();
            while((i=fis.read()) != -1){
                result.append((char) i);
            }
            fis.close();
            return result.toString();
        } catch (Exception ex) {
            System.out.println(""+ex);
        }
        return "File not found";
    }

    public String readLines(){
        String read = read();
        String[] array = read.split("\n");
        if (array.length < toLine) toLine = array.length;
        String[] fromLineToLineArray = new String[toLine-fromLine+1];
        for (int i = fromLine-1, j = 0; i < toLine; i++, j++) {
            fromLineToLineArray[j] = array[i] + "\n";
        }
        StringBuilder fromArrayToString = new StringBuilder();
        Arrays.stream(fromLineToLineArray).forEach(fromArrayToString::append);
        return fromArrayToString.toString();
    }
}

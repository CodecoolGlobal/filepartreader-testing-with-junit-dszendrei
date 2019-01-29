import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFileWordAnalyzer {

    FilePartReader filePartReader = new FilePartReader();
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Before
    public void init(){
        filePartReader.setup(FilePartReader.poemFilePath, 1,10);
    }

    @Test
    public void testGetWordsOrderedAlphabetically(){
        List<String> expected = Arrays.asList("Because","Do","Do","Good","Old","Rage","Their","Though","a","against","age","and","at","at","bay","bright","burn","by","close","crying","danced","dark","day","deeds","dying","end","forked","frail","gentle","gentle","go","go","good","good","green","had","have","how","in","into","into","is","know","last","light","lightning","men","men","might","night","night","no","not","not","of","of","rage","rave","right","should","that","that","the","the","the","their","their","they","wave","wise","words");
        assertEquals("Alphabetically testing: ", expected , fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstring(){
        List<String> expected = Arrays.asList("Do","good","Old","should","and","day","dying","end","dark","words","had","forked","Do","good","Good","deeds","danced");
        assertEquals("Containing substring testing: ", expected , fileWordAnalyzer.getWordsContainingSubstring("d"));
    }

    @Test
    public void testGetStringsWhichPalindromes(){
        List<String> expected = Arrays.asList("a");
        assertEquals("Testing Palindromes: ", expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }

}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFilePartReader {

    private FilePartReader filePartReader = new FilePartReader();

    @Before
    public void init(){
        filePartReader.setup(FilePartReader.poemFilePath, 1,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitFromLine(){
        filePartReader.setup("", -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitToLine(){
        filePartReader.setup("", 2, 1);
    }

    @Test
    public void testReadFileNotFound(){
        filePartReader.setup("", 1, 1);
        assertEquals("File read error: ", "File not found", filePartReader.read());
    }

    @Test
    public void testRead(){
        assertEquals("The first line: ", "Do not go gentle into that good night,\n" +
                "Old age should burn and rave at close of day;\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "Though wise men at their end know dark is right,\n" +
                "Because their words had forked no lightning they\n" +
                "Do not go gentle into that good night.\n" +
                "\n" +
                "Good men, the last wave by, crying how bright\n" +
                "Their frail deeds might have danced in a green bay,\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "Wild men who caught and sang the sun in flight,\n" +
                "And learn, too late, they grieved it on its way,\n" +
                "Do not go gentle into that good night.\n" +
                "\n" +
                "Grave men, near death, who see with blinding sight\n" +
                "Blind eyes could blaze like meteors and be gay,\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "And you, my father, there on the sad height,\n" +
                "Curse, bless, me now with your fierce tears, I pray.\n" +
                "Do not go gentle into that good night.\n" +
                "Rage, rage against the dying of the light.\n", filePartReader.read());
    }

    @Test
    public void testReadlines(){
        assertEquals("Readline test: ", "Do not go gentle into that good night,\n", filePartReader.readLines());
    }
}

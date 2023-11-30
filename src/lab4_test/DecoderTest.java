package lab4_test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import lab4.Decoder;
public class DecoderTest {

    @Test
    public void testDecodeMessage() {
        String encodedMessage = "t2st3ng vetviph";
        String decodedMessage = Decoder.decodeMessage(encodedMessage);
        assertEquals("testing decoding", decodedMessage);
    }

    @Test
    public void testDecodeMessageWithNumbers() {
        String encodedMessage = "1s 2n3s4s5n";
        String decodedMessage = Decoder.decodeMessage(encodedMessage);
        assertEquals("as ensisuson", decodedMessage);
    }

    @Test
    public void testDecodeMessageWithSpecialCharacters() {
        String encodedMessage = "h3ll4! th5r3";
        String decodedMessage = Decoder.decodeMessage(encodedMessage);
        assertEquals("hello! there", decodedMessage);
    }
}

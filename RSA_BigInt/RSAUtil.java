import java.math.BigInteger;


public class RSAUtil
{
    // This only works when the msg is 8 chars or less because
    // the message will overflow the 8 bytes in a long datatype.
    public static BigInteger messageTextToBigInteger(String msg)
    {
        // convert the string to an array of bytes.
        byte[] chars = msg.getBytes();
        // Convert the array of bytes into a single long value
        return new BigInteger(chars);
    }

    public static String BigIntegerToMessageText(BigInteger code)
    {
        byte[] bytes = code.toByteArray();
        return new String(bytes);
    }  
}
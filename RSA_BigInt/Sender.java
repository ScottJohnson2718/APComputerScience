
import java.math.BigInteger;

public class Sender 
{
    public Sender()
    {
    }

    public void Send(String message, Receiver receiver)
    {
        System.out.println("Sender encoding message : " + message);
        BigInteger messageAsNumber = RSAUtil.messageTextToBigInteger(message);

        System.out.println("The message as an integer is :" + messageAsNumber);

        // This sender gets the public key information that the receiver publishes.
        BigInteger E = receiver.getPublicKeyE();
        BigInteger n = receiver.getPublicKeyN();

        // Encrypt the message using the RSA Cryptography math.
        // encryptedMessageAsNumber = (P ^ E) mod n;
        BigInteger encryptedMessageAsNumber = messageAsNumber.modPow(E, n);

        // The message was encrypted with E and n. The only way the message can be decrypted
        // is to know the multiplicative inverse of E mod (p-1)*(q-1). But to do that, the cracker
        // would need to know p and q in order to compute (p-1)*(q-1). The cracker doesn't
        // know p and q. It has to factor n into p and q. p and q are chosen so large that
        // no computer can do it within years.

        System.out.println("Sender sending encoded message : " + encryptedMessageAsNumber);
        receiver.receive(encryptedMessageAsNumber);
    }
    
 
}

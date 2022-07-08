import java.math.BigInteger;
import java.util.Random;

// The receiver publishes its data for its public key. It also receives encrypted messages that were
// encoded with its public key and decodes them.
// The RSA math comes from "Algorithms and Complexity" by Herbert Wilf.
public class Receiver 
{
    // Two prime numbers. They should each be 100 digits or larger.
    // It is absolutely critical that no one but the receiver know what these numbers are, otherwise
    // the encrypted messages can be cracked! This is the perfect data to be declared private.
    private BigInteger p, q;

    // The product p * q. This number is published to senders. The senders only get the product
    // of p and q, not the individual numbers p and q.
    private BigInteger n;

    // E is a random number that must be relatively prime to (p-1)(q-1)
    // This is part of the RSA math. E is a part of the public key and is used
    // to encode messages to this receiver.
    private BigInteger E;

    // This is a part of the RSA math and is used for decoding messages sent to this receiver.
    // D is the multiplicative inverse of E mod (p-1)(q-1)
    private BigInteger D; // multiplicative inverse of E mod (p-1)(q-1)

    // The product (p-1)*(q-1). Again, part of the RSA math. This is used a few places so it
    // is calculated once in the constructor.
    private BigInteger prod;

    // Index into the primes table.
    private int nextPrimeIndex = 0;

    public Receiver()
    {
        // Get primes for p and q from the table
        this.p = primes[nextPrimeIndex++];
        this.q = primes[nextPrimeIndex++];
        this.n = this.p.multiply(this.q);
        // prod = (p-1)*(q-1)
        this.prod = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.E = FindE(p, q);

        this.D = this.E.modInverse(this.prod);
    }

    public BigInteger getPublicKeyN()
    {
        return this.n;
    }

    public BigInteger getPublicKeyE()
    {
        return this.E;
    }

    public static boolean isRelativelyPrime(BigInteger a, BigInteger b)
    {
        BigInteger gcd = a.gcd(b);
        return gcd.equals(BigInteger.ONE);
    }

    public BigInteger FindE(BigInteger p, BigInteger q)
    {
        Random rand = new Random();
        
        long tries = 1;
        BigInteger E = new BigInteger(256, rand);
        while (!isRelativelyPrime(E, this.prod) && tries < 1000000)
        {
            tries++;
            E = E.add(BigInteger.ONE);
        }
        if (tries == 1000000)
        {
            System.out.println("Failed to find a suitable value E");
        }
        else
        {
            //System.out.println("Found a suitable value for E in " + tries + " tries.");
        }
        return E;
    }
    
    // Receives an encoded message, decodes it and prints the decoded message
    public void receive(BigInteger encryptedMessageAsNumber)
    {
        System.out.println("Receiver received msg : " + encryptedMessageAsNumber);
        
        // Do the decryption math on the number 'encryptedMessageAsNumber' to get a decrypted number
        // Decrypt by computing: (encryptedMessageAsNumber)^D mod n
        BigInteger decryptedMessageAsNumber = encryptedMessageAsNumber.modPow(D, n);

        // Convert the decrypted number back to a string for printing
        String decryptedMessageText = RSAUtil.BigIntegerToMessageText(decryptedMessageAsNumber);
        System.out.println("Receiver decoded message : " + decryptedMessageText);
    }
   
    // This is a table of large primes to use. They come from the web site.  There are only
    // enough values for two receivers!
    // https://asecuritysite.com/encryption/random3?val=256
    private static BigInteger[] primes = new BigInteger[]
    {
        new BigInteger("35954278638777487163995063531756529979237497452331065665791326057144692237889"),
        new BigInteger("83521853358207674078277556584706121099426696584638987621863750536796331209567"),
        new BigInteger("46962109727091992990477957077076424079884790121419776117173492601771057125369"),
        new BigInteger("43813000859566243745230369157563085663521013875927363798973295756372912658841")
    };
}


// A toy example of RSA Cryptography.
// This is the highest level class that sets up the message and calls the sender and receivers.
public class RSA
{
    public static void main(String[] args)
    {
        String message = "We attack at dawn!";
        // The sender is going to encode and send the message
        Sender Alice = new Sender();
  
        // The first receiver
        Receiver Bob = new Receiver();
        Alice.Send(message, Bob);

        System.out.println("-----------");

        // The second receiver
        // Note that when the encrypted message is encoded, it is different than the message to the first
        // receiver even though it is the same message.
        Receiver Carl = new Receiver();

        Alice.Send(message, Carl);
    }
}
public class VigenereCipher
{
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toLowerCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'a' || c > 'z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toLowerCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'a' || c > 'z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'a');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static void main(String[] args)
    {
        String key = "ovaltine";
        String message = "Be Sure To Drink Your Ovaltine!";
        String encryptedMsg = encrypt(message, key);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
    }
}

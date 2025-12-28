/**
 * Encryption and Decryption for Vigenere cipher with key
 * 
 * @author YBZ
 * @version 1.0.0
 */
public class VigenereCipher
{
	private final String KEY;

	/**
	 * initializes key into lowercase
	 * 
	 * @param key
	 * @since 1.0.0
	 */
	public VigenereCipher(String key)
	{
		this.KEY = key.toLowerCase();
	}

	/**
	 * encrypts plain text with key
	 * 
	 * @param text to encrypt
	 * @return encrypted text
	 * @since 1.0.0
	 */
	public String encrypt(String text)
	{
		String result = "";
		int cipherPos = 0;

		for (int t = 0; t < text.length(); t++)
		{
			boolean isUpper = (text.charAt(t) >= 'A' && text.charAt(t) <= 'Z');

			char letter =  text.toLowerCase().charAt(t);
			if (letter == ' ')
			{
				result+=" ";
				continue;
			}
			int cipherLetter = (int)((letter-'a')+(this.KEY.charAt(cipherPos)-'a'))%26;
			if (isUpper)
				result+=(char)(cipherLetter+'A');
			else
				result+=(char)(cipherLetter+'a');

			// key counter
			cipherPos++;
			if (cipherPos == this.KEY.length())
				cipherPos = 0;
		}
		return result;
	}

	/**
	 * decrypts encrypted text with key
	 * 
	 * @param text encrypted text
	 * @return plain text
	 * @since 1.0.0
	 */
	public String decrypt(String text)
	{
		String result = "";
		int cipherPos = 0;
		for (int t = 0; t < text.length(); t++)
		{
			boolean isUpper = (text.charAt(t) >= 'A' && text.charAt(t) <= 'Z');
			char letter = text.toLowerCase().charAt(t);
			if (letter == ' ')
			{
				result+=" ";
				continue;
			}

			int cipherLetter = (int)((letter-'a')-(this.KEY.charAt(cipherPos)-'a'))%26;
			if (cipherLetter<0)
				cipherLetter+=26;
			if (isUpper)
				result+=(char)(cipherLetter+'A');
			else
				result+=(char)(cipherLetter+'a');

			// key counter
			cipherPos++;
			if (cipherPos == this.KEY.length())
				cipherPos = 0;
		}
		return result;
	}
}
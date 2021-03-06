import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGameOfStrings {
	GameOfStrings stringObject = new GameOfStrings("Madam");
	@Test
	public void TestCountVowels() {
		int count = stringObject.countVowels();
		Assert.assertEquals(2,count);
	}
	@Test
	public void TestReverseString() {
		String reverseString = stringObject.reverseString();
		Assert.assertEquals("madaM", reverseString);
	}
	@Test
	public void TestCountWordsInString() {
		GameOfStrings wordsObject1 = new GameOfStrings("This sentence contains 5 words");
		int wordCount1 = wordsObject1.countWordsInString();
		Assert.assertEquals(5, wordCount1);
		GameOfStrings wordsObject2 = new GameOfStrings("This sentence contains 8 words. Oh my god!");
		int wordCount2 = wordsObject2.countWordsInString();
		Assert.assertEquals(8, wordCount2);
	}
	
	@Test
	public void TestPigLatin() {
		GameOfStrings pigLatin = new GameOfStrings("nanny");
		String latin = pigLatin.convertToPigLatin();
		Assert.assertEquals("annyn    ay", latin);
	}
	
	@Test
	public void TestCheckStringPalindrome() {
		boolean val = stringObject.checkStringPalindrome();
		Assert.assertEquals(true, val);
	}
	
	@Test
	public void TestIsZodiacSign() {
		GameOfStrings zodiac1 = new GameOfStrings("Caprecorn"); // Intentional mistake
		Assert.assertFalse(zodiac1.isZodiacSign());
		
		GameOfStrings zodiac2 = new GameOfStrings("Aries");
		Assert.assertTrue(zodiac2.isZodiacSign());
	}
}
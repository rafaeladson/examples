package net.fiive;

import com.google.common.base.Optional;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HiraganaTranslatorTest {

	private HiraganaTranslator translator = new HiraganaTranslator();



	@Test(dataProvider = "validHiraganas")
	public void translateValid(String text, int expectedTranslation) {
		Optional<Integer> translation = translator.translateToHiragana(text);
		Assert.assertTrue(translation.isPresent());
		Assert.assertEquals(new Integer(expectedTranslation), translation.get());

	}


	@DataProvider(name = "validHiraganas")
	public Object[][] validHiraganas() {
		Object[][] validHiraganas = new Object[6][];
		validHiraganas[0] = new Object[] {"a", R.string.a};
		validHiraganas[1] = new Object[] {"i", R.string.i};
		validHiraganas[2] = new Object[] {"ka", R.string.ka};
		validHiraganas[3] = new Object[] {"kya", R.string.kya};
		validHiraganas[4] = new Object[] {"ya", R.string.ya};
		validHiraganas[5] = new Object[] {"shi", R.string.shi};
		return validHiraganas;
	}


	@Test(dataProvider = "notFoundHiraganas")
	public void testHiraganaNotFound(String notFoundText) {
		Optional<Integer> translation = translator.translateToHiragana(notFoundText);
		Assert.assertFalse(translation.isPresent());
	}

	@DataProvider
	public void notFoundHiraganas() {
		Object[][] notFoundHiraganas = new Object[3][];
		notFoundHiraganas[0] = new String[] {"si"};
		notFoundHiraganas[1] = new String[] {""};
		notFoundHiraganas[2] = new String[] {"1"};
		notFoundHiraganas[3] = new String[] {"kyaa"};
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testTranslateNull() {
		translator.translateToHiragana(null);
	}

}

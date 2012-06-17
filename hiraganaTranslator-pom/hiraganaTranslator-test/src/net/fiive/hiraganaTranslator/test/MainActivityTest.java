package net.fiive.hiraganaTranslator.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import com.google.common.base.Optional;
import net.fiive.MainActivity;


public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

	private MainActivityUI ui;
	private MainActivity activity;


	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	public void setUp() throws Exception{
		super.setUp();
		startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class),
				     null, null);
		this.activity = getActivity();
		ui = new MainActivityUI(this.activity);

	}

	public void testValidHiragana() {
		ui.translateText("ka");
		assertEquals("か", ui.getTranslation());
	}

	public void testInvalidHiragana() {
		ui.translateText("si");
		assertEquals("", ui.getTranslation());
		Optional<String> error = ui.getInputError();
		assertTrue(error.isPresent());
		assertEquals(activity.getResources().getString(net.fiive.R.string.invalid_hiragana_error),
				    error.get());
		ui.translateText("shi");
		assertFalse(ui.getInputError().isPresent());
	}


}

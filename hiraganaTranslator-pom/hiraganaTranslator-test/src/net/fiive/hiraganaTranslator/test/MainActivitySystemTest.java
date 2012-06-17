package net.fiive.hiraganaTranslator.test;

import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;
import net.fiive.*;
import net.fiive.R;

public class MainActivitySystemTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public MainActivitySystemTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testTranslate() {
		solo.clearEditText(getActivity().getInput());
		solo.enterText(getActivity().getInput(), "ka");
		solo.clickOnButton(getActivity().getResources().getString(R.string.translate));
		assertEquals("か", getActivity().getOutput().getText().toString());
	}
}

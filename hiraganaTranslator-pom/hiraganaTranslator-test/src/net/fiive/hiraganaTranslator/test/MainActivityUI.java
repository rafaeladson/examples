package net.fiive.hiraganaTranslator.test;

import com.google.common.base.Optional;
import net.fiive.MainActivity;

public class MainActivityUI {

	private MainActivity activity;

	public MainActivityUI(MainActivity activity) {
		this.activity = activity;
	}

	public void translateText(String text) {
		activity.getInput().setText(text);
		activity.getTranslateButton().performClick();
	}

	public String getTranslation() {
		return activity.getOutput().getText().toString();

	}

	public Optional<String> getInputError() {
		CharSequence error = activity.getInput().getError();
		if ( error != null ) {
			return Optional.of(error.toString());
		} else {
			return Optional.absent();
		}
	}

}

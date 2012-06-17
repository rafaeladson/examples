package net.fiive.intern.android.view.validation;

import android.widget.EditText;

public class TextValidator {

	public boolean validateTextNotEmpty(EditText field, String textMessage) {
		String text = field.getText().toString();
		boolean validated = text != null && !"".equals(text);
		if (!validated) {
			field.setError(textMessage);
		} else {
			field.setError(null);
		}
		return validated;
	}

	/**
	 * Check if field has a text that has at most maxLength characters.
	 * If the field does have a longer text, the field will show a validation error.
	 * @param field The {@link EditText} being checked.
	 * @param maxLength the maximum length. For example, if maxLength == 5, 'hello' will be accepted, but 'foobar' will not.
	 * @param textMessage The message that will appear on the validation message if the text is longer than maxLength
	 * @return true if the validation worked, false otherwise.
	 */
	public boolean validateTextMaxLength(EditText field, Integer maxLength, String textMessage) {
		boolean validated = field.getText().toString().length() <= maxLength;
		if (!validated) {
			field.setError(textMessage);
		} else {
			field.setError(null);
		}
		return validated;
	}
}

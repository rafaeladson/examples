package net.fiive.intern.android.view.alerts;

public class ValidationFailedAlertInfo {

	private String title;
	private String message;
	private String continueButtonName;

	public ValidationFailedAlertInfo(String title, String message, String continueButtonName) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public String getContinueButtonName() {
		return continueButtonName;
	}
}

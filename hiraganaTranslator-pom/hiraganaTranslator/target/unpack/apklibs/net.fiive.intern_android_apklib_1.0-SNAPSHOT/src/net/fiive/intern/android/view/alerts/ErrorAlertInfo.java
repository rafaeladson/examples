package net.fiive.intern.android.view.alerts;

public class ErrorAlertInfo {

	private String title;
	private String message;
	private String continueButtonName;

	public ErrorAlertInfo(String title, String message, String continueButtonName) {
		this.title = title;
		this.message = message;
		this.continueButtonName = continueButtonName;
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

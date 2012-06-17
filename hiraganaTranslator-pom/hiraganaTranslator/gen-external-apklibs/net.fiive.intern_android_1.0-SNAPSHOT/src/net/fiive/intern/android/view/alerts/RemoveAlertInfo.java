package net.fiive.intern.android.view.alerts;

public class RemoveAlertInfo {

	private String title;
	private String message;
	private String okButtonName;
	private String cancelButtonName;

	public RemoveAlertInfo(String title, String message, String okButtonName, String cancelButtonName) {
		this.title = title;
		this.message = message;
		this.okButtonName = okButtonName;
		this.cancelButtonName = cancelButtonName;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public String getOkButtonName() {
		return okButtonName;
	}

	public String getCancelButtonName() {
		return cancelButtonName;
	}
}

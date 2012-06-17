package net.fiive.intern.android.view.alerts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.common.base.Preconditions;

public class AlertHelper {


	public void showErrorAlert(Context context, ErrorAlertInfo errorAlertInfo, final Callback callback) {
		Preconditions.checkNotNull(context, "Error: Can't show alert message without a context");
		Preconditions.checkNotNull(errorAlertInfo, "Error: you should supply an object with the title, message and name of the button of the alert");


		   new AlertDialog.Builder(context).setTitle(errorAlertInfo.getTitle()).setMessage(errorAlertInfo.getMessage()).setPositiveButton(errorAlertInfo.getContinueButtonName(),
			new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					if ( callback != null ) {
						callback.notifyCallback();
					}
				}
			} ).show();
	}

	public void showRemoveAlert(Context context, RemoveAlertInfo removeAlertInfo, final Callback okCallback, final Callback cancelCallback) {
		Preconditions.checkNotNull(context);
		Preconditions.checkNotNull(removeAlertInfo);

		new AlertDialog.Builder(context).setTitle(removeAlertInfo.getTitle()).setMessage(removeAlertInfo.getMessage()).
			setPositiveButton(removeAlertInfo.getOkButtonName(), new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					if (okCallback != null) {
						okCallback.notifyCallback();
					}
				}
			}).setNegativeButton(removeAlertInfo.getCancelButtonName(), new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				if ( cancelCallback != null ) {
					cancelCallback.notifyCallback();
				}
			}
		}).show();
	}


	public static abstract class Callback {

		public void notifyCallback() {
			this.onCallback();
		}

		public abstract void onCallback();

	}

}

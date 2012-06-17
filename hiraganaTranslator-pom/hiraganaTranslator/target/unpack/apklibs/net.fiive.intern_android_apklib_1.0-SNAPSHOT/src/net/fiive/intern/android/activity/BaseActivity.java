package net.fiive.intern.android.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Every activity that uses Fragments in this project should inherit from BaseActivity.
 */
public abstract class BaseActivity extends FragmentActivity {

	/**
	 * Gets the fragment from an activity. I'm aware that there may be activities with more than one fragment, but I'm deciding to not support them for now (YAGNI).
	 * If this ever changes, this method should be refactored.
	 *
	 * @param <F> I'm using a bit of convention here, and I'm assuming that the client will always know which kind of Fragment the activity has.
	 *            This is better than using template on the class because client classes will have to cast Fragment anyway, so I think it is better to avoid all this
	 *            casting and assume that the programmer know what he is doing.
	 *            At worst, what will happen is a ClassCastException.
	 * @return the fragment of an Activity, assuming there is only one.
	 */
	public abstract <F extends Fragment> F getFragment();
}

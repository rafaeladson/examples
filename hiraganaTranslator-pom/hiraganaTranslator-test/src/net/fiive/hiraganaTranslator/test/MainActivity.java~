package net.fiive.kotoba.test.activities;


import android.content.Intent;
import android.os.Build;
import android.test.ActivityUnitTestCase;
import net.fiive.kotoba.activities.info.InfoActivity;
import net.fiive.kotoba.activities.questionEdit.QuestionEditActivity;
import net.fiive.kotoba.activities.questionList.QuestionListActivity;
import net.fiive.kotoba.test.screen.questionList.QuestionListScreen;

public class QuestionListFragmentTest extends ActivityUnitTestCase<QuestionListActivity> {

	private QuestionListScreen screen;

	public QuestionListFragmentTest() {
		super(QuestionListActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.startActivity(new Intent(getInstrumentation().getTargetContext(), QuestionListActivity.class), null, null);
		QuestionListActivity activity = this.getActivity();
		screen = QuestionListScreen.screenForUnitTests(activity);

	}

	public void testShouldDispatchIntentWhenUserClicksOnAItem() {
		screen.clickOnListItem(0);
		Intent editQuestionIntent = this.getStartedActivityIntent();
		assertEquals(QuestionEditActivity.EDIT_QUESTION_ACTION, editQuestionIntent.getAction());
		assertEquals("kotoba://kotoba.fiive.net/question/0", editQuestionIntent.getDataString());
	}


	public void testShouldDispatchIntentWhenUserClicksOnNewQuestionMenu() {
		screen.selectNewQuestionMenu();
		assertAddNewQuestionIntentWasDispatched();
	}

	public void testSeeInfo() {
		screen.selectInfoMenu();
		Intent infoIntent = this.getStartedActivityIntent();
		assertEquals(InfoActivity.VIEW_INFO_ACTION, infoIntent.getAction());
	}

	public void testShouldDispatchNewQuestionIntentWhenUserClicksOnAddNewQuestionOnTheTable() {
		if (Build.VERSION.SDK_INT < 11) {
			screen.clickOnAddNewQuestion();
			assertAddNewQuestionIntentWasDispatched();
		}
	}

	private void assertAddNewQuestionIntentWasDispatched() {
		Intent addQuestionIntent = this.getStartedActivityIntent();
		assertEquals(QuestionEditActivity.ADD_QUESTION_ACTION, addQuestionIntent.getAction());
		assertEquals("kotoba://kotoba.fiive.net/question/new", addQuestionIntent.getDataString());
	}
}

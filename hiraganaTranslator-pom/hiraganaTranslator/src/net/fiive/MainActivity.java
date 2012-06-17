package net.fiive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class MainActivity extends Activity {

	private EditText input;
	private TextView output;
	private Button translateButton;
	private HiraganaTranslator translator = new HiraganaTranslator();




	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		input = (EditText) findViewById(R.id.hiraganaInput);
		output = (TextView) findViewById(R.id.hiraganaOutput);
		translateButton = (Button) findViewById(R.id.translateButton);
		translateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				translateHiragana(input.getText().toString());
			}
		});
	}

	private void translateHiragana(String text) {
		Optional<Integer> result = translator.translateToHiragana(text);
		if ( result.isPresent() ) {
			String translation = this.getResources().getString(result.get());
			output.setText(translation);
			input.setError(null);
		} else {
			output.setText("");
			input.setError(getResources().getString(R.string.invalid_hiragana_error));
		}
	}


	public EditText getInput() {
		return input;
	}

	public TextView getOutput() {
		return output;
	}

	public Button getTranslateButton() {
		return translateButton;
	}
}

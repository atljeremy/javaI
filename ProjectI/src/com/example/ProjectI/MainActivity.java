package com.example.ProjectI;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.Random;

public class MainActivity extends Activity {

    /**
     * Project I Requirements:
     *
     * The application must contain, at minimum, 1 of each of the following Java components:
     *
     * int or float variable √
     * boolean variable √
     * String variable √
     * loop (any type) √
     * condition √
     * function (in addition to the event click handler) √
     * click event handler √
     *
     * The application must also utilize, at minimum, 1 of each of the following Android components:
     *
     * Android resource value √
     * TextView √
     * EditText √
     * Button √
     * LinearLayout √
     */

    /**
     * Global motorcycle array used by to hold the String values of all 5 motorcycles that will be used
     */
    private static final String[] mMotorcycles = new String[5];
    private EditText editText;
    private TextView results;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        populateMotorcycleArray();
        createUIElements();
    }

    /**
     * Used to create all custom UI Elements with one method call
     */
    private void createUIElements() {
        LinearLayout layout = createLinearLayout();

        TextView howToPlay = createTextview(layout);
        howToPlay.setText(getString(R.string.howToPlay));

        createEditText(layout);
        createButton(layout);

        this.results = createTextview(layout);
    }

    /**
     * Custom LinearLayout
     */
    private LinearLayout createLinearLayout() {
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.BLACK);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(layoutParams);
        this.addContentView(layout, params);

        return layout;
    }

    /**
     * Custom TextView
     */
    private TextView createTextview(LinearLayout layout) {
        TextView textView = new TextView(this);
        layout.addView(textView, getLayoutParams());
        return textView;
    }

    /**
     * Custom EditText
     */
    private void createEditText(LinearLayout layout) {
        this.editText = new EditText(this);
        layout.addView(this.editText, getLayoutParams());
    }

    /**
     * Custom Button
     */
    private void createButton(LinearLayout layout) {
        Button button = new Button(this);
        button.setText("Get Bike!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String toastMessage;
                String resultsText;

                if (MainActivity.this.editText.length() > 0) {
                    int chosenIndex = -1;
                    boolean isNumeric;

                    try {
                       chosenIndex = Integer.parseInt(MainActivity.this.editText.getText().toString()) - 1;
                       isNumeric = true;
                    } catch (Exception exception) {
                       isNumeric = false;
                    }

                    if (!isNumeric || !motorCylceExistsAtIndex(chosenIndex)) {
                        toastMessage = getString(R.string.pleaseChooseBetween);
                        resultsText = getString(R.string.emptyString);
                    } else {
                        Random random = new Random();
                        int min = 0, max = 4;
                        int randomIndex = random.nextInt(max - min + 1) + min;

                        if (randomIndex == chosenIndex) {
                            toastMessage = getString(R.string.youWin);
                        } else {
                            toastMessage = getString(R.string.tryAgain);
                        }

                        StringBuilder finalResult = new StringBuilder(getString(R.string.results));
                        finalResult.append(getString(R.string.youChose));
                        finalResult.append(" " + motorcycleNameAtIndex(chosenIndex));
                        finalResult.append(getString(R.string.iChose));
                        finalResult.append(" " + motorcycleNameAtIndex(randomIndex));
                        resultsText = finalResult.toString();
                    }
                } else {
                    toastMessage = getString(R.string.emptyTextView);
                    resultsText = getString(R.string.emptyString);
                }

                MainActivity.this.results.setText(resultsText);
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        layout.addView(button, getLayoutParams());
    }

    /**
     * Used in the custom view creation methods to set the layout params
     * @return LayoutParams
     */
    private ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        return new ViewGroup.LayoutParams(layoutParams);
    }

    /**
     * Use this method to grab the String value for the motorcycle at the given index
     *
     * @param index
     * @return the name of the motorcycle at this given index
     */
    private String motorcycleNameAtIndex(int index) {
        String motorcycleName = "";
        if (motorCylceExistsAtIndex(index))
            motorcycleName = this.mMotorcycles[index];
        return motorcycleName;
    }

    /**
     * Populates the mMotorcycles array with the 5 bikes we'll be using
     */
    private void populateMotorcycleArray() {
        String[] motorcycleNames = new String[this.mMotorcycles.length];
        motorcycleNames[0] = getString(R.string.ducati);
        motorcycleNames[1] = getString(R.string.honda);
        motorcycleNames[2] = getString(R.string.suzuki);
        motorcycleNames[3] = getString(R.string.kawasaki);
        motorcycleNames[4] = getString(R.string.harleyDavidson);

        for (int i=0; i<this.mMotorcycles.length; i++) {
            this.mMotorcycles[i] = motorcycleNames[i];
        }
    }

    /**
     * This helper method can be used to determine in a motorcycle exists at a given index.
     *
     * @param index
     * @return a boolean signifying whether or not a motorcycle exists at the given index
     */
    private boolean motorCylceExistsAtIndex(int index) {
        boolean motorcycleExists = false;
        if (this.mMotorcycles.length >= index) {
            String motorcycleFromArray = this.mMotorcycles[index];
            if (null != motorcycleFromArray) motorcycleExists = true;
        }
        return motorcycleExists;
    }
}

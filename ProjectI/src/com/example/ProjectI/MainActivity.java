package com.example.ProjectI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
     * Android resource value
     * TextView √
     * EditText √
     * Button √
     * LinearLayout
     */

    /**
     * Global motorcycle array used by to hold the String values of all 5 motorcycles tat will be used
     */
    private static final String[] mMotorcycles = new String[5];

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
        createTextview();
        createEditText();
        createButton();
    }

    /**
     *
     * @return a TextView which will be used in our custom UI
     */
    private TextView createTextview() {
        TextView textView = new TextView(this);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(layoutParams);
        this.addContentView(textView, params);
        return textView;
    }

    /**
     *
     * @return an EditText which will be used in our custom UI
     */
    private EditText createEditText() {
        EditText editText = new EditText(this);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(layoutParams);
        this.addContentView(editText, params);
        return editText;
    }

    /**
     *
     * @return a Button which will be used in our custom UI
     */
    private Button createButton() {
        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "BOOM", Toast.LENGTH_LONG).show();
            }
        });

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(layoutParams);
        this.addContentView(button, params);
        return button;
    }

    /**
     * Use this method to grab the String value for the motorcycle at the given index
     *
     * @param index
     * @return the name of the motorcycle at this given index
     */
    private String motorcycleNameAtIndex(int index) {
        String motorcycleName = "";
        if (doesMotorCylceExistAtIndex(index))
            motorcycleName = this.mMotorcycles[index];
        return motorcycleName;
    }

    /**
     * Populates the mMotorcycles array with the 5 bikes we'll be using
     */
    private void populateMotorcycleArray() {
        String[] motorcyleNames = new String[this.mMotorcycles.length];
        motorcyleNames[0] = "Ducati Monster";
        motorcyleNames[1] = "Honda CBR";
        motorcyleNames[2] = "Suzuki GXSR";
        motorcyleNames[3] = "Kawasaki Ninja";
        motorcyleNames[4] = "Harley-Davidson V-Rod";

        for (int i=0; i<this.mMotorcycles.length; i++) {
            this.mMotorcycles[i] = motorcyleNames[i];
        }
    }

    /**
     * This helper method can be used to determine in a motorcycle exists at a given index.
     *
     * @param index
     * @return a boolean signifying whether or not a motorcycle exists at the given index
     */
    private boolean doesMotorCylceExistAtIndex(int index) {
        boolean motorcycleExists = false;
        if (this.mMotorcycles.length >= index) {
            String motorcycleFromArray = this.mMotorcycles[index];
            if (null != motorcycleFromArray) motorcycleExists = true;
        }
        return motorcycleExists;
    }
}

package me.riddhimanadib.formmaster.model;

import android.graphics.Color;

/**
 * Object for header of the form lists
 * Created by Adib on 18-Apr-17.
 */

public class FormHeader extends BaseFormElement {

    private int backgroundColor = Color.LTGRAY;
    public FormHeader() {
    }

    /**
     * static method to create instance with title
     * @param title
     * @return
     */
    public static FormHeader createInstance(String title) {
        FormHeader formHeader = new FormHeader();
        formHeader.setType(BaseFormElement.TYPE_HEADER);
        formHeader.setTitle(title);
        return formHeader;
    }

    public FormHeader setBackgroundColor(int color) {
        this.backgroundColor = color;
        return this;
    }

    public int getBackgroundColor() {return backgroundColor; }

}

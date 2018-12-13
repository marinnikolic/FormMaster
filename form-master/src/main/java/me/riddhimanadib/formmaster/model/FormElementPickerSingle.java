package me.riddhimanadib.formmaster.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.R;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerSingle extends BaseFormElement {

    private String pickerTitle; // custom title for picker
    private List<String> mOptions; // list of options for single and multi picker
    private List<String> mOptionsSelected; // list of selected options for single and multi picker
    private Drawable drawable;
    private boolean hideDrawable = false;

    public FormElementPickerSingle() { }

    public static FormElementPickerSingle createInstance() {
        FormElementPickerSingle formElementPickerSingle = new FormElementPickerSingle();
        formElementPickerSingle.setType(BaseFormElement.TYPE_PICKER_SINGLE);
        formElementPickerSingle.setPickerTitle("Pick one");
        return formElementPickerSingle;
    }

    public FormElementPickerSingle setTag(int mTag) {
        return (FormElementPickerSingle)  super.setTag(mTag);
    }

    public FormElementPickerSingle setType(int mType) {
        return (FormElementPickerSingle)  super.setType(mType);
    }

    public FormElementPickerSingle setTitle(String mTitle) {
        return (FormElementPickerSingle)  super.setTitle(mTitle);
    }

    public FormElementPickerSingle setValue(String mValue) {
        return (FormElementPickerSingle)  super.setValue(mValue);
    }

    public FormElementPickerSingle setHint(String mHint) {
        return (FormElementPickerSingle)  super.setHint(mHint);
    }

    public FormElementPickerSingle setRequired(boolean required) {
        return (FormElementPickerSingle)  super.setRequired(required);
    }

    public FormElementPickerSingle setEditable(boolean editable) {
        return (FormElementPickerSingle)  super.setEditable(editable);
    }

    public FormElementPickerSingle setValueColor(int color) {
        return (FormElementPickerSingle) super.setValueColor(color);
    }

    public FormElementPickerSingle setTitleColor(int color) {
        return (FormElementPickerSingle) super.setTitleColor(color);
    }

    // custom setters
    public FormElementPickerSingle setOptions(List<String> mOptions) {
        this.mOptions = mOptions;
        return this;
    }

    public FormElementPickerSingle setOptionsSelected(List<String> mOptionsSelected) {
        this.mOptionsSelected = mOptionsSelected;
        return this;
    }

    public FormElementPickerSingle setPickerTitle(String title) {
        this.pickerTitle = title;
        return this;
    }

    // custom getters
    public List<String> getOptions() {
        return (this.mOptions == null) ? new ArrayList<String>() : this.mOptions;
    }

    /*public boolean isDrawableHidden() { return hideDrawable; }

    public FormElementPickerSingle hideDrawable(boolean hide) {
        this.hideDrawable = hide;
        return this;
    }*/

    public Drawable getDrawable() { return drawable; }

    public FormElementPickerSingle setDrawable(Drawable drawable) {
        this.drawable = drawable;
        return this;
    }

    public List<String> getOptionsSelected() {
        return (this.mOptionsSelected == null) ? new ArrayList<String>() : this.mOptionsSelected;
    }

    public String getPickerTitle() {
        return this.pickerTitle;
    }

}

package me.riddhimanadib.formmaster.model;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.EditText;

/**
 * Created by Adib on 16-Apr-17.
 */

public class BaseFormElement {

    // different types for the form elements
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_EDITTEXT_TEXT_SINGLELINE = 1;
    public static final int TYPE_EDITTEXT_TEXT_MULTILINE = 2;
    public static final int TYPE_EDITTEXT_NUMBER = 3;
    public static final int TYPE_EDITTEXT_EMAIL = 4;
    public static final int TYPE_EDITTEXT_PHONE = 5;
    public static final int TYPE_EDITTEXT_PASSWORD = 6;
    public static final int TYPE_PICKER_DATE = 7;
    public static final int TYPE_PICKER_TIME = 8;
    public static final int TYPE_PICKER_SINGLE = 9;
    public static final int TYPE_PICKER_MULTI = 10;
    public static final int TYPE_SWITCH = 11;
    public static final int TYPE_BUTTON = 12;

    // private variables
    private int mTag; // unique tag to identify the object
    private int mType; // type for the form element
    private String mTitle; // title to be shown on left
    private String mValue; // value to be shown on right
    private String mHint; // value to be shown if mValue is null
    private String validationPattern;
    private boolean mRequired; // value to set is the field is required
    private boolean mEditable = true;
    private boolean optionalRequired;
    private int mValueColor =  Color.GRAY;
    private int mTitleColor =  Color.BLACK;
    private int mHintColor = Color.BLACK;
    private int backgroundColor;

    // setters
    public BaseFormElement setTag(int mTag) {
        this.mTag = mTag;
        return this;
    }

    public BaseFormElement setType(int mType) {
        this.mType = mType;
        return this;
    }

    public BaseFormElement setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public BaseFormElement setValue(String mValue) {
        this.mValue = mValue;
        return this;
    }

    public BaseFormElement setHint(String mHint) {
        this.mHint = mHint;
        return this;
    }

    public BaseFormElement setRequired(boolean required) {
        this.mRequired = required;
        return this;
    }

    public BaseFormElement setOptionalRequired(boolean optionalRequired) {
        this.optionalRequired = optionalRequired;
        return this;
    }

    public BaseFormElement setEditable(boolean editable) {
        this.mEditable = editable;
        return this;
    }

    public BaseFormElement setTitleColor(int color) {
        this.mTitleColor = color;
        return this;
    }

    public BaseFormElement setValueColor(int color) {
        this.mValueColor = color;
        return this;
    }

    public BaseFormElement setHintColor(int color) {
        mHintColor = color;
        return this;
    }

    public BaseFormElement setBackgroundColor(int color) {
        backgroundColor = color;
        return this;
    }

    // getters
    public int getTag() {
        return this.mTag;
    }

    public int getType() {
        return this.mType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getValue() {
        return (this.mValue == null) ? "" : this.mValue;
    }

    public String getHint() {
        return (this.mHint == null) ? "" : this.mHint;
    }

    public boolean isRequired() {
        return this.mRequired;
    }

    public boolean isOptionalRequired() { return this.optionalRequired; }

    public boolean isEditable() {
        return this.mEditable;
    }

    public int getTitleColor() { return this.mTitleColor; }

    public int getValueColor() { return this.mValueColor; }

    public int getHintColor() { return this.mHintColor; }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String toString() {
        return "BaseFormElement{" +
                "mTag=" + mTag +
                ", mType=" + mType +
                ", mTitle='" + mTitle + '\'' +
                ", mValue='" + mValue + '\'' +
                ", mHint='" + mHint + '\'' +
                ", mRequired=" + mRequired +
                '}';
    }

    public String getValidationPattern() {
        return validationPattern;
    }

    public void setValidationPattern(String validationPattern) {
        this.validationPattern = validationPattern;
    }
}

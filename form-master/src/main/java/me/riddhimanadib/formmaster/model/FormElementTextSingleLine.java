package me.riddhimanadib.formmaster.model;

import java.text.Normalizer;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextSingleLine extends BaseFormElement {

    public FormElementTextSingleLine() {
    }

    public static FormElementTextSingleLine createInstance() {
        FormElementTextSingleLine formElementTextSingleLine = new FormElementTextSingleLine();
        formElementTextSingleLine.setType(BaseFormElement.TYPE_EDITTEXT_TEXT_SINGLELINE);
        return formElementTextSingleLine;
    }

    public FormElementTextSingleLine setTag(int mTag) {
        return (FormElementTextSingleLine)  super.setTag(mTag);
    }

    public FormElementTextSingleLine setType(int mType) {
        return (FormElementTextSingleLine)  super.setType(mType);
    }

    public FormElementTextSingleLine setTitle(String mTitle) {
        return (FormElementTextSingleLine)  super.setTitle(mTitle);
    }

    public FormElementTextSingleLine setValue(String mValue) {
        return (FormElementTextSingleLine)  super.setValue(mValue);
    }

    public FormElementTextSingleLine setHint(String mHint) {
        return (FormElementTextSingleLine)  super.setHint(mHint);
    }

    public FormElementTextSingleLine setRequired(boolean required) {
        return (FormElementTextSingleLine)  super.setRequired(required);
    }

    public FormElementTextSingleLine setEditable(boolean editable) {
        return (FormElementTextSingleLine)  super.setEditable(editable);
    }

    public FormElementTextSingleLine setTitleColor(int color) {
        return (FormElementTextSingleLine) super.setTitleColor(color);
    }

    public FormElementTextSingleLine setValueColor(int color) {
        return (FormElementTextSingleLine) super.setValueColor(color);
    }

    public FormElementTextSingleLine setHintColor(int color) {
        return (FormElementTextSingleLine) super.setHintColor(color);
    }
}

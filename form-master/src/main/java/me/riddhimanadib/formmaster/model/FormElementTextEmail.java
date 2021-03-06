package me.riddhimanadib.formmaster.model;

import android.widget.EditText;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextEmail extends BaseFormElement {

    public FormElementTextEmail() {
    }

    public static FormElementTextEmail createInstance() {
        FormElementTextEmail FormElementTextEmail = new FormElementTextEmail();
        FormElementTextEmail.setType(BaseFormElement.TYPE_EDITTEXT_EMAIL);
        return FormElementTextEmail;
    }

    public FormElementTextEmail setTag(int mTag) {
        return (FormElementTextEmail)  super.setTag(mTag);
    }

    public FormElementTextEmail setType(int mType) {
        return (FormElementTextEmail)  super.setType(mType);
    }

    public FormElementTextEmail setTitle(String mTitle) {
        return (FormElementTextEmail)  super.setTitle(mTitle);
    }

    public FormElementTextEmail setValue(String mValue) {
        return (FormElementTextEmail)  super.setValue(mValue);
    }

    public FormElementTextEmail setHint(String mHint) {
        return (FormElementTextEmail)  super.setHint(mHint);
    }

    public FormElementTextEmail setRequired(boolean required) {
        return (FormElementTextEmail)  super.setRequired(required);
    }
    public FormElementTextEmail setEditable(boolean editable) {
        return (FormElementTextEmail)  super.setEditable(editable);
    }

    public FormElementTextEmail setTitleColor(int color) {
        return (FormElementTextEmail) super.setTitleColor(color);
    }

    public FormElementTextEmail setValueColor(int color) {
        return (FormElementTextEmail) super.setValueColor(color);
    }

    public  FormElementTextEmail setHintColor(int color) {
        return (FormElementTextEmail) super.setHintColor(color);
    }
}

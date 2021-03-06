package me.riddhimanadib.formmaster.model;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextPhone extends BaseFormElement {

    public FormElementTextPhone() {
    }

    public static FormElementTextPhone createInstance() {
        FormElementTextPhone FormElementTextPhone = new FormElementTextPhone();
        FormElementTextPhone.setType(BaseFormElement.TYPE_EDITTEXT_PHONE);
        return FormElementTextPhone;
    }

    public FormElementTextPhone setTag(int mTag) {
        return (FormElementTextPhone)  super.setTag(mTag);
    }

    public FormElementTextPhone setType(int mType) {
        return (FormElementTextPhone)  super.setType(mType);
    }

    public FormElementTextPhone setTitle(String mTitle) {
        return (FormElementTextPhone)  super.setTitle(mTitle);
    }

    public FormElementTextPhone setValue(String mValue) {
        return (FormElementTextPhone)  super.setValue(mValue);
    }

    public FormElementTextPhone setHint(String mHint) {
        return (FormElementTextPhone)  super.setHint(mHint);
    }

    public FormElementTextPhone setRequired(boolean required) {
        return (FormElementTextPhone)  super.setRequired(required);
    }
    public FormElementTextPhone setEditable(boolean editable) {
        return (FormElementTextPhone)  super.setEditable(editable);
    }

    public FormElementTextPhone setTitleColor(int color) {
        return (FormElementTextPhone) super.setTitleColor(color);
    }

    public FormElementTextPhone setValueColor(int color) {
        return (FormElementTextPhone) super.setValueColor(color);
    }

    public FormElementTextPhone setHintColor(int color) {
        return (FormElementTextPhone) super.setHintColor(color);
    }
}

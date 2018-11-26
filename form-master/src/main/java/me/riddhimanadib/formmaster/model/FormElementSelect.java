package me.riddhimanadib.formmaster.model;

import android.graphics.drawable.Drawable;

public class FormElementSelect extends BaseFormElement {

    private Drawable drawable;

    public FormElementSelect() { }

    public static FormElementSelect createInstance() {
        FormElementSelect formElementSelect = new FormElementSelect();
        formElementSelect.setType(BaseFormElement.TYPE_BUTTON);
        return formElementSelect;
    }

    public FormElementSelect setTag(int mTag) {
        return (FormElementSelect)  super.setTag(mTag);
    }

    public FormElementSelect setType(int mType) {
        return (FormElementSelect)  super.setType(mType);
    }

    public FormElementSelect setTitle(String mTitle) {
        return (FormElementSelect)  super.setTitle(mTitle);
    }

    public FormElementSelect setValue(String mValue) {
        return (FormElementSelect)  super.setValue(mValue);
    }

    public FormElementSelect setHint(String mHint) {
        return (FormElementSelect)  super.setHint(mHint);
    }

    public FormElementSelect setRequired(boolean required) {
        return (FormElementSelect)  super.setRequired(required);
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}

package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.FormItemEditTextListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementTextMultiLineViewHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;
    public AppCompatEditText mEditTextValue;
    public FormItemEditTextListener mFormCustomEditTextListener;

    public FormElementTextMultiLineViewHolder(View v, FormItemEditTextListener listener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mFormCustomEditTextListener = listener;
        setEditTextValueSettings();
    }

    @Override
    public FormItemEditTextListener getListener() {
        return mFormCustomEditTextListener;
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {

        setEditTextParameters(formElement);
        setFieldEditable(formElement);
        changingTextColor(formElement);

        if (!formElement.isEditable()) return;

        setItemViewClickListener(context);
    }

    private void setEditTextValueSettings() {
        mEditTextValue.addTextChangedListener(mFormCustomEditTextListener);
        mEditTextValue.setMaxLines(4);
        mEditTextValue.setSingleLine(false);
        mEditTextValue.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    private void setItemViewClickListener(final Context context) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextValue.requestFocus();
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(mEditTextValue, InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }

    private void setEditTextParameters(BaseFormElement formElement) {
        mTextViewTitle.setText(formElement.getTitle());
        mEditTextValue.setText(formElement.getValue());
        mEditTextValue.setHint(formElement.getHint());
    }

    private void setFieldEditable(BaseFormElement formElement) {
        mTextViewTitle.setEnabled(formElement.isEditable());
        mEditTextValue.setEnabled(formElement.isEditable());
    }

    private void changingTextColor(BaseFormElement formElement) {
        mTextViewTitle.setTextColor(formElement.getTitleColor());
        if(formElement.getValue().equals("") || formElement.getValue() == null)
            mEditTextValue.setHintTextColor(formElement.getHintColor());
        else
            mEditTextValue.setTextColor(formElement.getValueColor());
    }
}

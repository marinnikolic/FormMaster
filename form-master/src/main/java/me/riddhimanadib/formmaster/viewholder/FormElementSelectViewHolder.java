package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.OnSelectListener;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementSelect;

public class FormElementSelectViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatTextView mTextViewValue;
    private AppCompatImageButton mImageButton;
    private ReloadListener mReloadListener;
    private FormElementSelect mFormElement;
    private OnSelectListener mOnSelectListener;
    private int mPosition;

    public FormElementSelectViewHolder(View v, Context context, ReloadListener reloadListener, OnSelectListener onSelectListener) {
        super(v);
        mTextViewTitle = v.findViewById(R.id.formElementTitle);
        mTextViewValue = v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
        mOnSelectListener = onSelectListener;
    }

    @Override
    public void bind(int position, BaseFormElement formElement, Context context) {
        mFormElement = (FormElementSelect) formElement;
        mPosition = position;

        setEditTextParameters(formElement);
        setFieldEditable(formElement);
        changingTextColor(formElement);

        if (!formElement.isEditable()) return;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnSelectListener == null) {
                    return;
                }
                mOnSelectListener.didPressFormElement(mFormElement);
            }
        });
    }

    private void setFieldEditable(BaseFormElement formElement) {
        mTextViewTitle.setText(formElement.getTitle());
        mTextViewValue.setText(formElement.getValue());
        mTextViewValue.setHint(formElement.getHint());
    }

    private void setEditTextParameters(BaseFormElement formElement) {
        mTextViewTitle.setEnabled(formElement.isEditable());
        mTextViewValue.setEnabled(formElement.isEditable());
    }

    private void changingTextColor(BaseFormElement formElement) {
        mTextViewValue.setTextColor(formElement.getValueColor());
        mTextViewTitle.setTextColor(formElement.getTitleColor());
    }
}

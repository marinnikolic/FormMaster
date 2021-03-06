package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;


/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementPickerSingleViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private ReloadListener mReloadListener;
    private BaseFormElement mFormElement;
    private FormElementPickerSingle mFormElementPickerSingle;
    private int mPosition;
    private AppCompatImageView mDropdownImage;

    public FormElementPickerSingleViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
        mDropdownImage = v.findViewById(R.id.dropdownIcon);
    }

    @Override
    public void bind(final int position, BaseFormElement formElement, final Context context) {
        mFormElement = formElement;
        mPosition = position;
        mFormElementPickerSingle = (FormElementPickerSingle) mFormElement;

        setEditTextParameters(formElement);
        setFieldEditable(formElement);
        changingTextColor(formElement);
        setDrawableIcon();
        hideDrawable();

        AlertDialog dialog = reformatOptionsInFormatNeeded(position, context);

        if (!formElement.isEditable()) return;

        editTextValueClickListener(dialog);
        textViewTitleClickListener(dialog);

    }

    private void setEditTextParameters(BaseFormElement formElement) {
        mTextViewTitle.setText(formElement.getTitle());
        mEditTextValue.setText(formElement.getValue());
        mEditTextValue.setHint(formElement.getHint());
        mEditTextValue.setFocusableInTouchMode(false);
    }

    private void setFieldEditable(BaseFormElement formElement) {
        mTextViewTitle.setEnabled(formElement.isEditable());
        mEditTextValue.setEnabled(formElement.isEditable());
    }

    private void hideDrawable() {
        if(mFormElementPickerSingle.isDrawableHidden())
            mDropdownImage.setVisibility(View.GONE);
        else
            mDropdownImage.setVisibility(View.VISIBLE);
    }

    private void changingTextColor(BaseFormElement formElement) {
        mTextViewTitle.setTextColor(formElement.getTitleColor());
        if(formElement.getValue().equals("") || formElement.getValue() == null)
            mEditTextValue.setHintTextColor(formElement.getHintColor());
        else
            mEditTextValue.setTextColor(formElement.getValueColor());
    }

    private void setDrawableIcon() {
        if(mFormElementPickerSingle.getDrawable() != null) {
            mDropdownImage.setVisibility(View.VISIBLE);
            mDropdownImage.setImageDrawable(mFormElementPickerSingle.getDrawable());
        }
    }

    private void editTextValueClickListener(final AlertDialog dialog) {
        mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    private void textViewTitleClickListener(final AlertDialog dialog) {
        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    private AlertDialog reformatOptionsInFormatNeeded(final int position, final Context context) {
        final CharSequence[] options = new CharSequence[mFormElementPickerSingle.getOptions().size()];
        for (int i = 0; i < mFormElementPickerSingle.getOptions().size(); i++) {
            options[i] = mFormElementPickerSingle.getOptions().get(i);
        }

        final AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(mFormElementPickerSingle.getPickerTitle())
                .setItems(options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mEditTextValue.setText(options[which]);
                        mFormElementPickerSingle.setValue(options[which].toString());
                        mReloadListener.updateValue(position, options[which].toString());
                    }
                })
                .create();
        return dialog;
    }
}

package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.ArrayList;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerMulti;

/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementPickerMultiViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private ReloadListener mReloadListener;
    private BaseFormElement mFormElement;
    private FormElementPickerMulti mFormElementPickerMulti;
    private int mPosition;

    public FormElementPickerMultiViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
    }

    @Override
    public void bind(final int position, BaseFormElement formElement, final Context context) {
        mFormElement = formElement;
        mPosition = position;
        mFormElementPickerMulti = (FormElementPickerMulti) mFormElement;

        setEditTextParameters(formElement);
        setFieldEditable(formElement);
        changingTextColor(formElement);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[mFormElementPickerMulti.getOptions().size()];
        final boolean[] optionsSelected = new boolean[mFormElementPickerMulti.getOptions().size()];
        final ArrayList<Integer> mSelectedItems = new ArrayList();

        reformatOptionsInFormatNeeded(optionsSelected, options, mSelectedItems);
        // prepare the dialog
        AlertDialog dialog = dialogPrepare(context, optionsSelected, options, mSelectedItems, position);

        if(!formElement.isEditable()) return;

        editTextValueClickListener(dialog);
        textViewTitleClickListener(dialog);
    }

    private void reformatOptionsInFormatNeeded(boolean[] optionsSelected, final CharSequence[] options, final ArrayList<Integer> mSelectedItems) {
        for (int i = 0; i < mFormElementPickerMulti.getOptions().size(); i++) {
            options[i] = mFormElementPickerMulti.getOptions().get(i);
            optionsSelected[i] = false;

            if (mFormElementPickerMulti.getOptionsSelected().contains(options[i])) {
                optionsSelected[i] = true;
                mSelectedItems.add(i);
            }
        }
    }

    private AlertDialog dialogPrepare(Context context, boolean[] optionsSelected, final CharSequence[] options, final ArrayList<Integer> mSelectedItems, final int position) {
        final AlertDialog dialog  = new AlertDialog.Builder(context)
                .setTitle(mFormElementPickerMulti.getPickerTitle())
                .setMultiChoiceItems(options, optionsSelected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton(mFormElementPickerMulti.getPositiveText(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String s = "";
                        for (int i = 0; i < mSelectedItems.size(); i++) {
                            s += options[mSelectedItems.get(i)];

                            if (i < mSelectedItems.size() - 1) {
                                s += ", ";
                            }
                        }
                        mEditTextValue.setText(s);
                        mReloadListener.updateValue(position, s);
                    }
                })
                .setNegativeButton(mFormElementPickerMulti.getNegativeText(), null)
                .create();
        return dialog;
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

    private void changingTextColor(BaseFormElement formElement) {
        mTextViewTitle.setTextColor(formElement.getTitleColor());
        if(formElement.getValue().equals("") || formElement.getValue() == null)
            mEditTextValue.setHintTextColor(formElement.getHintColor());
        else
            mEditTextValue.setTextColor(formElement.getValueColor());
    }
}

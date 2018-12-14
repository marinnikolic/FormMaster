package me.riddhimanadib.formmaster.viewholder;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerDate;

/**
 * ViewHolder for DatePicker
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementPickerDateViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private DatePickerDialog mDatePickerDialog;
    private Calendar mCalendarCurrentDate;
    private ReloadListener mReloadListener;
    private BaseFormElement mFormElement;
    private int mPosition;
    private DatePickerDialog.OnDateSetListener date;

    public FormElementPickerDateViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
        mCalendarCurrentDate = java.util.Calendar.getInstance();
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {
        mFormElement = formElement;
        mPosition = position;

        settingUpDatePickerDialogListener();
        setUpDatePickerDialog(context);

        setEditTextParameters(formElement);
        setFieldEditable(formElement);
        changingTextColor(formElement);

        if(!formElement.isEditable()) return;

        editTextValueClickListener();
        textViewTitleClickListener();
    }

    private void settingUpDatePickerDialogListener() {
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mCalendarCurrentDate.set(Calendar.YEAR, year);
                mCalendarCurrentDate.set(Calendar.MONTH, monthOfYear);
                mCalendarCurrentDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormatDate = ((FormElementPickerDate) mFormElement).getDateFormat();
                SimpleDateFormat sdfDate = new SimpleDateFormat(myFormatDate, Locale.US);

                String currentValue = mFormElement.getValue();
                String newValue = sdfDate.format(mCalendarCurrentDate.getTime());

                // trigger event only if the value is changed
                if (!currentValue.equals(newValue)) {
                    mReloadListener.updateValue(mPosition, newValue);
                }
            }

        };
        this.date = date;
    }

    private void setUpDatePickerDialog(Context context) {
        mDatePickerDialog = new DatePickerDialog(context,
                date,
                mCalendarCurrentDate.get(Calendar.YEAR),
                mCalendarCurrentDate.get(Calendar.MONTH),
                mCalendarCurrentDate.get(Calendar.DAY_OF_MONTH));
    }

    private void setFieldEditable(BaseFormElement formElement) {
        mTextViewTitle.setEnabled(formElement.isEditable());
        mEditTextValue.setEnabled(formElement.isEditable());
    }

    private  void changingTextColor(BaseFormElement formElement) {
        mTextViewTitle.setTextColor(formElement.getTitleColor());
        if(formElement.getValue().equals("") || formElement.getValue() == null)
            mEditTextValue.setHintTextColor(formElement.getHintColor());
        else
            mEditTextValue.setTextColor(formElement.getValueColor());
    }

    private void setEditTextParameters(BaseFormElement formElement) {
        mTextViewTitle.setText(formElement.getTitle());
        mEditTextValue.setText(formElement.getValue());
        mEditTextValue.setHint(formElement.getHint());
        mEditTextValue.setFocusableInTouchMode(false);
    }

    private void editTextValueClickListener() {
        mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
            }
        });
    }

    private void textViewTitleClickListener() {
        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
            }
        });
    }
}

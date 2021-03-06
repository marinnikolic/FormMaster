package me.riddhimanadib.formmaster.viewholder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerTime;

/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementPickerTimeViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private TimePickerDialog mTimePickerDialog;
    private Calendar mCalendarCurrentTime;
    private ReloadListener mReloadListener;
    private BaseFormElement mFormElement;
    private int mPosition;
    private TimePickerDialog.OnTimeSetListener time;

    public FormElementPickerTimeViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
        mCalendarCurrentTime = java.util.Calendar.getInstance();

        setUpTimePickerDialogListener();
        initializeTimePickerDialogVariable(context);
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {
        mFormElement = formElement;
        mPosition = position;
        mTextViewTitle.setText(formElement.getTitle());

        setEditTextValueParameters(formElement);
        setFieldEditable(formElement);
        changingTextColor(formElement);
        
        if (!formElement.isEditable()) return;

        setEditTextValueClickListener();
        setTextViewTitleClickListener();
    }

    private void initializeTimePickerDialogVariable(Context context) {
        mTimePickerDialog = new TimePickerDialog(context,
                time,
                mCalendarCurrentTime.get(Calendar.HOUR),
                mCalendarCurrentTime.get(Calendar.MINUTE),
                false);
    }

    private void setUpTimePickerDialogListener() {
        TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mCalendarCurrentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                mCalendarCurrentTime.set(Calendar.MINUTE, minute);

                String myFormatTime = ((FormElementPickerTime) mFormElement).getTimeFormat();
                SimpleDateFormat sdfTime = new SimpleDateFormat(myFormatTime);

                String currentValue = mFormElement.getValue();
                String newValue = sdfTime.format(mCalendarCurrentTime.getTime());
                // trigger event only if the value is changed
                if (!currentValue.equals(newValue)) {
                    mReloadListener.updateValue(mPosition, newValue);
                }
            }
        };
        this.time = time;
    }

    private void setTextViewTitleClickListener() {
        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimePickerDialog.show();
            }
        });
    }

    private void setEditTextValueClickListener() {
        mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimePickerDialog.show();
            }
        });
    }

    private void setEditTextValueParameters(BaseFormElement formElement) {
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

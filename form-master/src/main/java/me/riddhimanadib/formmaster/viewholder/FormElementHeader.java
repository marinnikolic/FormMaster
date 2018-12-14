package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementSelect;
import me.riddhimanadib.formmaster.model.FormHeader;

/**
 * ViewHolder for Header
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementHeader extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;
    private View view;
    private FormHeader formHeader;

    public FormElementHeader(View v) {
        super(v);
        view = v;
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {
        mTextViewTitle.setText(formElement.getTitle());
        formHeader = (FormHeader) formElement;
        changeBackgorungColor(formHeader, view);
    }

    private void changeBackgorungColor(FormHeader formElement, View v) {
        v.setBackgroundColor(formElement.getBackgroundColor());
    }
}

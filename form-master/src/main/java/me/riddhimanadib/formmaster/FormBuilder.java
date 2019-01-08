package me.riddhimanadib.formmaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.riddhimanadib.formmaster.adapter.FormAdapter;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.listener.OnSelectListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementSelect;

/** Wrapper class around the adapter to assist in building form
 * Created by Adib on 16-Apr-17.
 */

public class FormBuilder {

    private FormAdapter mFormAdapter;
    private Context context;

    /**
     * constructor without listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuilder(Context context, RecyclerView recyclerView) {
        initializeFormBuildHelper(context, recyclerView, null, null);
    }

    /**
     * constructor with listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuilder(Context context, RecyclerView recyclerView, OnFormElementValueChangedListener listener) {
        initializeFormBuildHelper(context, recyclerView, listener, null);
    }

    public FormBuilder(Context context, RecyclerView recyclerView, OnSelectListener onSelectListener) {
        initializeFormBuildHelper(context, recyclerView, null, onSelectListener);
    }

    public FormBuilder(Context context, RecyclerView recyclerView, OnFormElementValueChangedListener listener, OnSelectListener onSelectListener) {
        initializeFormBuildHelper(context, recyclerView, listener, onSelectListener);
    }
    /**
     * private method for initializing form build helper
     * @param context
     * @param recyclerView
     * @param listener
     */
    private void initializeFormBuildHelper(Context context, RecyclerView recyclerView, OnFormElementValueChangedListener listener, OnSelectListener onSelectListener) {

        this.context = context;
        // initialize form adapter
        this.mFormAdapter = new FormAdapter(context, listener, onSelectListener);
        // set up the recyclerview with adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setStackFromEnd(false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mFormAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void reloadFormElements() {
        this.mFormAdapter.notifyDataSetChanged();
    }

    /**
     * add list of form elements to be shown
     * @param baseFormElements
     */
    public void addFormElements(List<BaseFormElement> baseFormElements) {
        this.mFormAdapter.addElements(baseFormElements);
    }

    /**
     * get value of specific form element
     * @param tag
     * @return
     */
    public BaseFormElement getFormElement(int tag) {
        return this.mFormAdapter.getValueAtTag(tag);
    }

    /**
     *
     * return true if the form is valid
     *
     * @return
     */
    public boolean isValidForm() {
        int notValidFormElements = 0;
        for(int i = 0; i < mFormAdapter.getItemCount(); i ++) {
            BaseFormElement baseFormElement = mFormAdapter.getValueAtIndex(i);

            if (!baseFormElement.isRequired()) {
                setValidElementColorProperties(baseFormElement);
                continue;
            }

            if(!checkAndValidateFormElement(baseFormElement)) {
                notValidFormElements ++;
                setNotValidElementColorProperties(baseFormElement);
                continue;
            }

            setValidElementColorProperties(baseFormElement);
        }
        reloadFormElements();
        return !(notValidFormElements > 0);
    }

    private boolean checkAndValidateFormElement(BaseFormElement baseFormElement) {

        if(baseFormElement.getValue().equals("") || baseFormElement.getValue() == null) {
            return false;
        }

        if(baseFormElement.getValidationPattern() == null || baseFormElement.getValidationPattern().equals("")) {
            return true;
        }

        Pattern pattern = Pattern.compile(baseFormElement.getValidationPattern());
        Matcher matcher = pattern.matcher(baseFormElement.getValue());
        return matcher.matches();
    }

    private void setValidElementColorProperties(BaseFormElement baseFormElement) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        int color = typedValue.data;
        baseFormElement.setTitleColor(color);
        baseFormElement.setValueColor(color);
        baseFormElement.setHintColor(color);
    }

    private void setNotValidElementColorProperties(BaseFormElement baseFormElement) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        int color = typedValue.data;
        baseFormElement.setTitleColor(color);
        baseFormElement.setValueColor(color);
        baseFormElement.setHintColor(color);
    }
}
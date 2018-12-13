package me.riddhimanadib.fastformbuilder;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerDate;
import me.riddhimanadib.formmaster.model.FormElementPickerMulti;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;
import me.riddhimanadib.formmaster.model.FormElementPickerTime;
import me.riddhimanadib.formmaster.model.FormElementSelect;
import me.riddhimanadib.formmaster.model.FormElementSwitch;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormElementTextMultiLine;
import me.riddhimanadib.formmaster.model.FormElementTextNumber;
import me.riddhimanadib.formmaster.model.FormElementTextPassword;
import me.riddhimanadib.formmaster.model.FormElementTextPhone;
import me.riddhimanadib.formmaster.model.FormElementTextSingleLine;
import me.riddhimanadib.formmaster.model.FormHeader;
import me.riddhimanadib.formmaster.viewholder.FormElementHeader;

public class FormListenerActivity extends AppCompatActivity implements OnFormElementValueChangedListener {

    private RecyclerView mRecyclerView;
    private FormBuilder mFormBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_form);

        setupToolBar();

        setupForm();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolBar() {

        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

    }

    private void setupForm() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mFormBuilder = new FormBuilder(this, mRecyclerView, this);

        //FormHeader header1 = FormHeader.createInstance("Personal Info");
        FormElementTextEmail element11 = FormElementTextEmail.createInstance().setTitle("Email").setValue("nekiMail@gmail.com");
        FormElementTextPhone element12 = FormElementTextPhone.createInstance().setTitle("Phone").setValue("+8801712345678");
        FormElementPickerSingle e1 = FormElementPickerSingle.createInstance().setTitle("PICKER").setValue("Test picker");

        FormHeader header2 = FormHeader.createInstance("Family Info");
        FormElementTextSingleLine element21 = FormElementTextSingleLine.createInstance().setTitle("Location").setValue("Dhaka");
        FormElementTextMultiLine element22 = FormElementTextMultiLine.createInstance().setTitle("Address");
        FormElementTextNumber element23 = FormElementTextNumber.createInstance().setTitle("Zip Code").setValue("1000");

        FormHeader h1 = FormHeader.createInstance("Family Info");
        FormElementTextSingleLine e11 = FormElementTextSingleLine.createInstance().setTitle("Location").setValue("Dhaka");
        FormElementTextMultiLine e2 = FormElementTextMultiLine.createInstance().setTitle("Address");
        FormElementTextNumber e3 = FormElementTextNumber.createInstance().setTitle("Zip Code").setValue("1000");

        FormHeader h2 = FormHeader.createInstance("Family Info");
        FormElementTextSingleLine e4 = FormElementTextSingleLine.createInstance().setTitle("Location").setValue("Dhaka");
        FormElementTextMultiLine e5 = FormElementTextMultiLine.createInstance().setTitle("Address");
        FormElementTextNumber e6 = FormElementTextNumber.createInstance().setTitle("Zip Code").setValue("1000");

        FormHeader header3 = FormHeader.createInstance("Schedule");
        FormElementPickerDate element31 = FormElementPickerDate.createInstance().setTitle("Date").setDateFormat("MMM dd, yyyy");

        FormElementPickerTime element32 = FormElementPickerTime.createInstance().setTitle("Time").setTimeFormat("kk:mm");
        FormElementTextPassword element33 = FormElementTextPassword.createInstance().setTitle("Password").setValue("abcd1234");

        FormElementSwitch element43 = FormElementSwitch.createInstance().setTitle("Frozen?").setSwitchTexts("Yes", "No");

        List<BaseFormElement> formItems = new ArrayList<>();

        //formItems.add(header1);
        formItems.add(element11);
        formItems.add(element12);
        formItems.add(e1);

        formItems.add(h1);
        formItems.add(e11);
        formItems.add(e2);
        formItems.add(e3);
        formItems.add(h2);
        formItems.add(e4);
        formItems.add(e5);
        formItems.add(e6);


        formItems.add(header2);
        formItems.add(element21);
        formItems.add(element22);
        formItems.add(element23);
        formItems.add(header3);
        formItems.add(element31);
        formItems.add(element32);
        formItems.add(element33);
        formItems.add(element43);

        mFormBuilder.addFormElements(formItems);
    }

    @Override
    public void onValueChanged(BaseFormElement formElement) {
        Toast.makeText(this, formElement.getValue(), Toast.LENGTH_SHORT).show();
    }
}

package android.game.converterapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox getCalendar;
    private CalendarView calendarView;
    private TextView dateText;
    private TextView textException;
    private EditText editTextMeters;
    private EditText editTextCentimeters;
    private Button btnConvert;
    private Button editTextEntranceButton;
    private ToggleButton switchConverting;
    private boolean cmToM = false;
    private EditText editTextTextPersonName;
    private EditText editTextPhone;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private RadioButton radioButton;
    private TextView textViewMeters;
    private TextView textViewCentimeters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void convert(View view) {
        try{
            convertLogics();
        }
        catch(Exception e){
            textException.setText(e.toString());
        }
    }

    public void comeIn(View view) {
        editTextEntranceButton.setVisibility(View.GONE);
        editTextTextPersonName.setVisibility(View.GONE);
        editTextPhone.setVisibility(View.GONE);
        editTextTextEmailAddress.setVisibility(View.GONE);
        editTextTextPassword.setVisibility(View.GONE);
        setConverterVisibility(View.VISIBLE);
    }

    private void convertLogics(){
        System.out.println("cmToM = " + cmToM);
        if(cmToM){
            convertCmToM();
        }else{
            convertMToCm();
        }
    }

    private void convertCmToM(){
        if(!editTextCentimeters.getText().toString().equals("")){
            int m = Integer.parseInt(editTextCentimeters.getText().toString()) / 100;
            System.out.println("cm = " + m);
            editTextMeters.setText(Integer.toString(m));
        } else if(editTextCentimeters.getText().toString().equals(" ")){
            textException.setText("Поле с сантиметрами пустое");
        }
    }

    private void convertMToCm(){
        if(!editTextMeters.getText().toString().equals("")){
            int cm = Integer.parseInt(editTextMeters.getText().toString()) * 100;
            editTextCentimeters.setText(Integer.toString(cm));
        } else if(editTextMeters.getText().toString().equals("")){
            textException.setText("Поле с метрами пустое");
        }
    }


    private void init() {
        initViews();
        initCalendar();
        initSwitchConverting();
        setConverterVisibility(View.GONE);
    }


    private void initSwitchConverting() {
        switchConverting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cmToM = true;
                    System.out.println("cmToM = " + cmToM);
                }
                else {
                    cmToM = false;
                    System.out.println("cmToM = " + cmToM);
                }
            }
        });
    }

    private void setConverterVisibility(int view){
        getCalendar.setVisibility(view);
        dateText.setVisibility(view);
        editTextMeters.setVisibility(view);
        editTextCentimeters.setVisibility(view);
        btnConvert.setVisibility(view);
        textException.setVisibility(view);
        switchConverting.setVisibility(view);
        radioButton.setVisibility(view);
        textViewMeters.setVisibility(view);
        textViewCentimeters.setVisibility(view);
    }

    private void initCalendar(){
        getCalendar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    calendarView.setVisibility(View.VISIBLE);
                    editTextMeters.setVisibility(View.GONE);
                    editTextCentimeters.setVisibility(View.GONE);
                    btnConvert.setVisibility(View.GONE);
                    System.out.println("Pressed +");
                }
                else {
                    calendarView.setVisibility(View.GONE);
                    editTextMeters.setVisibility(View.VISIBLE);
                    editTextCentimeters.setVisibility(View.VISIBLE);
                    btnConvert.setVisibility(View.VISIBLE);
                    System.out.println("Pressed -");
                    String date = Long.toString(calendarView.getDate());
                    if (date != null){
                        dateText.setText(date);
                    }
                }
            }
        });
    }

    private void initViews() {
        getCalendar = findViewById(R.id.getCalendar);
        calendarView = findViewById(R.id.calendarView);
        dateText = findViewById(R.id.dateText2);
        calendarView.setVisibility(View.GONE);
        editTextMeters = findViewById(R.id.editTextMeters);
        editTextCentimeters = findViewById(R.id.editTextCentimeters);
        btnConvert = findViewById(R.id.btnConvert);
        editTextEntranceButton = findViewById(R.id.editTextEntranceButton);
        textException = findViewById(R.id.textException);
        switchConverting = findViewById(R.id.switchConverting);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        textViewMeters = findViewById(R.id.textViewMeters);
        textViewCentimeters = findViewById(R.id.textViewCentimeters);
        radioButton = findViewById(R.id.radioButton);
    }

}
package com.example.kuno.datetimeex;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;
/*
DatePicker
 - 화면에 날짜를 표시하고 원하는 날짜를 선택할 수 있게 해주는 뷰
 - DatePicker 표현하려면 DatePickerDialog를 사용하면 됩니다.

 TimePicker
  - 화면에 시간을 표시하고 원하는 시간을 설정할 수 있게 해주는 뷰
  - TimePicker 표현하려면 TimePickerDialog를 사용하면 됩니다.

*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Calendar dateAndTime = Calendar.getInstance();

    DateFormat dfDateAndTime = DateFormat.getDateTimeInstance();
    TextView tvDateAndTime;
    Button btnDateSelect, btnTimeSelect;

    DatePickerDialog.OnDateSetListener datepickerListener =
            new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dateAndTime.set(Calendar.YEAR, year);
                    dateAndTime.set(Calendar.MONTH, month);
                    dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    updateDateAndTime();
                }
            };

    TimePickerDialog.OnTimeSetListener timepickerListener =
            new TimePickerDialog.OnTimeSetListener(){

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    dateAndTime.set(Calendar.MINUTE, minute);

                    updateDateAndTime();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDateAndTime = (TextView)findViewById(R.id.tvText);
        btnDateSelect = (Button)findViewById(R.id.btnDateSelect);
        btnTimeSelect = (Button)findViewById(R.id.btntimeSelect);

        btnDateSelect.setOnClickListener(this);
        btnTimeSelect.setOnClickListener(this);

        updateDateAndTime();

    }

    private void updateDateAndTime(){
        tvDateAndTime.setText(dfDateAndTime.format(dateAndTime.getTime()));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnDateSelect){
            new DatePickerDialog(this, datepickerListener,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH)).show(); //show()를 호출해야 메모리상에 있는 datepicker객체를 보여줄 수 있다.
        }else if(v.getId() == R.id.btntimeSelect){
            new TimePickerDialog(this, timepickerListener,
                    dateAndTime.get(Calendar.HOUR_OF_DAY),
                    dateAndTime.get(Calendar.MINUTE), false).show();    //true, false 는 12시간,24시간 모드 설정
        }
    }
}

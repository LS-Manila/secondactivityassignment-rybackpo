package com.example.rybackpo.weekday20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.IllegalFormatException;

public class MainActivity extends AppCompatActivity {

    private Integer day, month, year, century, week_days_ends;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getInputValues(){
        EditText et_day = (EditText) findViewById(R.id.edittextday);
        EditText et_month = (EditText) findViewById(R.id.edittextmonth);
        EditText et_year = (EditText) findViewById(R.id.edittextyear);

        try{
            day = Integer.parseInt(et_day.getText().toString());
        }
        catch(IllegalFormatException e){
            day = 0;
        }
        try{
            month = Integer.parseInt(et_month.getText().toString());
        }
        catch(IllegalFormatException e){
            month = 0;
        }

        if (month == 1)
            month = 13;
        else if (month == 2)
            month = 14;

        try {
            s = et_year.getText().toString();
            year = Integer.parseInt(s.substring(2));
            century =  Integer.parseInt(s.substring(0, 2));
        }
        catch (Exception e){
            year = 0;
            century = 0;
        }

        et_day.setText(day.toString());
        et_month.setText(month.toString());
        et_year.setText(s);
    }

    private void computeDay(){
        week_days_ends = (day + (int)(26 *(month + 1)/10.0) + year + (int)(year/4.0) + (int)(century/4.0) + 5 * century ) % 7;
    }

    public void onClickCompute(View view){
        getInputValues();
        computeDay();
        printDay();
    }
    private void printDay(){
        String whatday;
        switch(week_days_ends){
            case 0:
                whatday = "It is Saturday";
                break;
            case 1:
                whatday = "It is Sunday";
                break;
            case 2:
                whatday = "It is Monday";
                break;
            case 3:
                whatday = "It is Tuesday";
                break;
            case 4:
                whatday = "It is Wednesday";
                break;
            case 5:
                whatday = "It is Thursday";
                break;
            case 6:
                whatday = "It is Friday";
                break;
            default:
                whatday = "Invalid";
        }
//        tv_out = (TextView) findViewById(R.id.textviewoutput);
//        tv_out.setText(whatday);

        Intent intent = new Intent(this, SecondMainActivity.class);
        intent.putExtra("PASSTHEMESSAGE",whatday);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

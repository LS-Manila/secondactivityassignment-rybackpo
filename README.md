# Linking Android Activities (secondactivityassignment-rybackpo)
secondactivityassignment-rybackpo created by Classroom for GitHub

This assignment illustrates the linking and passing data between activities using the Intent object.

## Problem:

Design and implement an Android application that determines the day of the week (Sunday through Saturday) given any date entered by the user. You could use this program

## Formula:

```Java
week_days_ends = (day + (int)(26 *(month + 1)/10.0) + year + (int)(year/4.0) + (int)(century/4.0) + 5 * century ) % 7;
```

where:

week_days_ends - the calculated day of the week (from 0 to 6) 

day     - the day entered by the user.

month   - the adjusted month (January and February are 13 and 14, not 1 and 2)

century - the century of the adjusted year (January and February are in the previous year). For example, if year is 1995, then century is 19

year    - the last two digits of the adjusted year (January and February are in the previous year) For example, if year is 1995, then year is 95

## Keypoint:

In the MainActivity.java:

```Java
        // Intent to go to the second activity
        Intent intent = new Intent(this, SecondMainActivity.class);
        
        // Passing of Data
        intent.putExtra("PASSTHEMESSAGE",whatday);
        startActivity(intent);
```

In the SecondActivity.java

```Java
        public void printDay(){
            String Date = getIntent().getStringExtra("PASSTHEMESSAGE");
            TextView textoutput = (TextView) findViewById(R.id.textviewoutput);
            textoutput.setText(Date);
        }
```

## Screenshots:

![alt tag](https://github.com/DeLaSalleUniversity-Manila/secondactivityassignment-rybackpo/blob/master/device-2015-10-02-170306.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/secondactivityassignment-rybackpo/blob/master/device-2015-10-02-170318.png)


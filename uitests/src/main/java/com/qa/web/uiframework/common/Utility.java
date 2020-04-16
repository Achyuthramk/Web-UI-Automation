package com.qa.web.uiframework.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utility {

    private static Utility utility = new Utility();

    private Utility(){}

    public static Utility getInstance(){
        return utility;
    }

    public File getResourceFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }

    public String getDate(int value) {
        Calendar calendar = null;
        SimpleDateFormat formater = null;
        try {
            formater = new SimpleDateFormat("MM/dd/yyyy");
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, value);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return formater.format(calendar.getTime());
    }

    public int getDay() {
        Random random = new Random();
        int day = (random.nextInt(25));
        return day+3;

    }
    public int getMonth() {
        Random random = new Random();
        int month= (random.nextInt(10)+2);
        return month;

    }

    public int getAdultyear() {
        Random random = new Random();
        int year= (random.nextInt(10) + 20);
        return year;

    }
}

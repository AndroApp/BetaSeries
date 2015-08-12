package com.betaseries.betaseries.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by florentchampigny on 04/08/15.
 */
public class DateUtils {

    public static String getMonthName(int month){

        switch (month){
            case 1:
                return "Janvier";
            case 2:
                return "Février";
            case 3:
                return "Mars";
            case 4:
                return "Avril";
            case 5:
                return "Mai";
            case 6:
                return "Juin";
            case 7:
                return "Juillet";
            case 8:
                return "Août";
            case 9:
                return "Septembre";
            case 10:
                return "Octobre";
            case 11:
                return "Novembre";
            default:
                return "Décembre";
        }
    }

    public static String getDayName(String nameEn){
        if("Monday".equalsIgnoreCase(nameEn))
            return "Lundi";
        else if("Tuesday".equalsIgnoreCase(nameEn))
            return "Mardi";
        else if("Wednesday".equalsIgnoreCase(nameEn))
            return "Mercredi";
        else if("Thursday".equalsIgnoreCase(nameEn))
            return "Jeudi";
        else if("Friday".equalsIgnoreCase(nameEn))
            return "Vendredi";
        else if("Saturday".equalsIgnoreCase(nameEn))
            return "Samedi";
        else
            return "Dimanche";

    }

    public static String getDateNow(String format){

        Date now = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(now);
    }

    public static String getDateFr(String date){
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1=format1.parse(date);
            DateFormat format2=new SimpleDateFormat("EEEE");

            Calendar c = Calendar.getInstance();
            c.setTime(dt1);

            return  getDayName(format2.format(dt1)) + " " + c.get(Calendar.DAY_OF_MONTH) + " " + getMonthName(c.get(Calendar.MONTH)+1) + " " + c.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getDateFrSmall(String date){
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1=format1.parse(date);
            DateFormat format2=new SimpleDateFormat("EEEE");

            Calendar c = Calendar.getInstance();
            c.setTime(dt1);

            return  c.get(Calendar.DAY_OF_MONTH) + " " + getMonthName(c.get(Calendar.MONTH)+1) + " " + c.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static boolean beforeNow(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(date);
            Date now = sdf.parse(getDateNow("yyyy-MM-dd"));

            return d.before(now);
        } catch (ParseException e) {
            e.printStackTrace();
            return  false;
        }
    }

}

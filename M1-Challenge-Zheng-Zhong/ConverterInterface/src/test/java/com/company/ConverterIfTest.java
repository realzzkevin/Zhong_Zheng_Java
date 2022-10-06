package com.company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//base on group work
public class ConverterIfTest {
    private ConverterIf converterIf;
    private ConverterSwitch converterSwitch;
    private List<String> month = Arrays.asList(new String[]{"January", "February", "March","April","May", "June",
            "July", "August","September", "October", "November", "December"});
    private List<String> day = Arrays.asList(new String[]{"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"});
    private String monthInvalidNumber = "valid number is 1 - 12";
    private String dayInvalidNumber = "number not in range of 1 - 7";
    @Before
    public void setUp(){
        converterIf = new ConverterIf();
        converterSwitch = new ConverterSwitch();
    }

    @Test
    public void shouldReturnExpectedMonthConverterIf() {
        for (int i = 0; i < 12; i++) {
            assertEquals(month.get(i), converterIf.convertMonth(i+1));
        }
    }
    @Test
    public void shouldReturnExpectedDayConverterIf() {
        for (int i = 0; i < 7; i++) {
            assertEquals(day.get(i), converterIf.convertDay(i+1));
        }
    }

    @Test
    public void shouldReturnWarringConverterIfMonth() {
        assertEquals(monthInvalidNumber, converterIf.convertMonth(0));
        assertEquals(monthInvalidNumber, converterIf.convertMonth(-1));
        assertEquals(monthInvalidNumber, converterIf.convertMonth(13));
        assertEquals(monthInvalidNumber, converterIf.convertMonth(15));
        assertEquals(monthInvalidNumber, converterIf.convertMonth(300));
    }

    @Test
    public void shouldReturnWarringConverterIfDay(){
        assertEquals(dayInvalidNumber, converterIf.convertDay(0));
        assertEquals(dayInvalidNumber, converterIf.convertDay(-1));
        assertEquals(dayInvalidNumber, converterIf.convertDay(8));
        assertEquals(dayInvalidNumber, converterIf.convertDay(10));
        assertEquals(dayInvalidNumber, converterIf.convertDay(300));
    }

    @Test
    public void shouldReturnExpectedMonthConverterSwitch() {
        for (int i = 0; i < 12; i++) {
            assertEquals(month.get(i), converterIf.convertMonth(i+1));
        }
    }

    @Test
    public void shouldReturnExpectedDayConverterSwitch() {
        for (int i = 0; i < 7; i++) {
            assertEquals(day.get(i), converterIf.convertDay(i+1));
        }
    }
    @Test
    public void shouldReturnWarringConverterSwitchMonth() {
        assertEquals(monthInvalidNumber, converterSwitch.convertMonth(0));
        assertEquals(monthInvalidNumber, converterSwitch.convertMonth(-1));
        assertEquals(monthInvalidNumber, converterSwitch.convertMonth(13));
        assertEquals(monthInvalidNumber, converterSwitch.convertMonth(15));
        assertEquals(monthInvalidNumber, converterSwitch.convertMonth(300));
    }

    @Test
    public void shouldReturnWarringConverterSwitchDay(){
        assertEquals(dayInvalidNumber, converterSwitch.convertDay(0));
        assertEquals(dayInvalidNumber, converterSwitch.convertDay(-1));
        assertEquals(dayInvalidNumber, converterSwitch.convertDay(8));
        assertEquals(dayInvalidNumber, converterSwitch.convertDay(10));
        assertEquals(dayInvalidNumber, converterSwitch.convertDay(300));
    }
}
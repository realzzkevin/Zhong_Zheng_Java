package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        ConverterIf converterIf = new ConverterIf();
        ConverterSwitch converterSwitch = new ConverterSwitch();

        System.out.println("Using if statement to Converter numbers to month");
        System.out.println("For month conversion, "+ converterIf.convertMonth(20));

        for(int i = 1; i <= 12; i++) {
            System.out.println("Number "+ i + " represents " + converterIf.convertMonth(i));
        }

        System.out.println("Using if statement to Converter numbers to day");
        System.out.println("If " +converterIf.convertDay(9)+", function will print a warring");
        for(int i = 1; i <= 7; i++) {
            System.out.println("Number "+ i + " represents " + converterIf.convertDay(i));
        }



        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Using switch statement to Converter numbers to month");
        System.out.println("For month conversion, "+ converterSwitch.convertMonth(20));
        for(int i = 1; i <= 12; i++) {
            System.out.println("Number "+ i + " represents " + converterSwitch.convertMonth(i));
        }

        System.out.println("Using switch statement to Converter numbers to day");
        System.out.println("If " +converterSwitch.convertDay(9)+", function will print a warring");
        for(int i = 1; i <= 7; i++) {
            System.out.println("Number "+ i + " represents " + converterSwitch.convertDay(i));
        }

    }
}

package com.example.myapp.myapp.action;

import android.content.Context;

import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import com.cloudpos.printer.PrinterDevice;

public class PrinterAction {
    private PrinterDevice device = null;


    public void printText(Context context, String param) {
        try {
            if (device == null) {
                device = (PrinterDevice) POSTerminal.getInstance(context)
                        .getDevice("cloudpos.device.printer");
            }
            device.open();
            System.out.println(param);
            device.printText(param);
            device.close();
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }
}
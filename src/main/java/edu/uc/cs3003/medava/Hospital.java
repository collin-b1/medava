package edu.uc.cs3003.medava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Hospital {

    private String name;

    public Hospital(String hospitalName) {
        name = hospitalName;
    }

    void receive(Transporter t) {
        while (!t.isEmpty()) {
            try {
                Object unloaded = t.unload();
                Method getScheduleMethod = unloaded.getClass().getMethod("getSchedule");
                MedicineSchedule getScheduleMethodResult = (MedicineSchedule) getScheduleMethod.invoke(unloaded);
                Method getMedicineNameMethod = unloaded.getClass().getMethod("getMedicineName");
                String getMedicineNameMethodResult = (String) getMedicineNameMethod.invoke(unloaded);
                System.out.printf("Checking whether Hospital can receive %s.%n", getMedicineNameMethodResult);
                if (getScheduleMethodResult != MedicineSchedule.Uncontrolled) {
                    System.out.printf("Hospital cannot receive controlled substances and %s is %s.%n", getMedicineNameMethodResult, getScheduleMethodResult);
                } else {
                    System.out.printf("Accepted a shipment of %s.%n", getMedicineNameMethodResult);
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException |
                     InvocationTargetException e) {
                // Don't do anything.
            }
        }
    }

    public String name() {
        return name;
    }
}
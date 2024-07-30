package edu.uc.cs3003.medava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Transporter {
    private String mTransporterName;
    //private List<Object> goods;
    private List<Shippable> goods;
    private double mLowTemperature, mHighTemperature;

    // Instance initializers
    {
        //goods = new ArrayList<Object>();
        goods = new ArrayList<Shippable>();
    }

    public Transporter(String transporterName, double lowTemp, double highTemp) {
        mTransporterName = transporterName;
        mLowTemperature = lowTemp;
        mHighTemperature = highTemp;
    }

    public String getTransporterName() {
        return mTransporterName;
    }

    public void ship() {

    }

    // Old load function using reflection
    /*public boolean load(Object itemToLoad) {
        try {
            Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
                    Double.class, Double.class);

            boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
                    Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
            if (resultOfMethodCall) {
                goods.add(itemToLoad);
            }
            return resultOfMethodCall;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }*/

    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            return goods.add(itemToLoad);
        }
        return false;
    }

    // Old unload method using reflection
    /*public Object unload() {
        return goods.remove(0);
    }*/

    public Shippable unload() {
        return goods.remove(0);
    }

    public boolean isEmpty() {
        return goods.isEmpty();
    }
}
package edu.uc.cs3003.medava;

import java.util.ArrayList;
import java.util.List;

public class Transporter {
    private String mTransporterName;
    public List<Medicine> goods;

    // Instance initializers
    {
        goods = new ArrayList<Medicine>();
    }

    public String getTransporterName() {
        return mTransporterName;
    }

    public void ship() {

    }
}
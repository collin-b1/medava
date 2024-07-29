package edu.uc.cs3003.medava;

public class Pharmacy {
    private String mPharmacyName;

    public Pharmacy(String pharmacyName) {
        mPharmacyName = pharmacyName;
    }

    public boolean send(Transporter t) {
        Medicine advil = new Ibuprofen();
        if (t.load(advil)) {
            System.out.printf("Sending %s on the %s transporter.%n", advil.getMedicineName(), t.getTransporterName());
        } else {
            System.out.printf("Cannot load %s onto the %s transporter.%n", advil.getMedicineName(), t.getTransporterName());
            return false;
        }

        Medicine activase = new Thrombolytic();
        if (t.load(activase)) {
            System.out.printf("Sending %s on the %s transporter.%n", activase.getMedicineName(), t.getTransporterName());
        } else {
            System.out.printf("Cannot load %s onto the %s transporter.%n", activase.getMedicineName(), t.getTransporterName());
            return false;
        }

        Medicine oxycontin = new Oxycodone();
        if (t.load(oxycontin)) {
            System.out.printf("Sending %s on the %s transporter.%n", oxycontin.getMedicineName(), t.getTransporterName());
        } else {
            System.out.printf("Cannot load %s onto the %s transporter.%n", oxycontin.getMedicineName(), t.getTransporterName());
            return false;
        }

        return true;
    }
}
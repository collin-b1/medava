package edu.uc.cs3003.medava;

public class Pharmacy {
    private String mPharmacyName;

    public Pharmacy(String pharmacyName) {
        mPharmacyName = pharmacyName;
    }

    public boolean send(Transporter t) {
        Medicine advil = new Medicine("Advil");
        if (t.load(advil)) {
            System.out.printf("Sending %s on the %s transporter.%n", advil.getMedicineName(), t.getTransporterName());
            return true;
        }
        System.out.printf("Cannot load %s onto the %s transporter.%n", advil.getMedicineName(), t.getTransporterName());
        return false;
    }
}
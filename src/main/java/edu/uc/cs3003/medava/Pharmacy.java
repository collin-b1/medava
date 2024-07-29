package edu.uc.cs3003.medava;

public class Pharmacy {
    private String mPharmacyName;

    public Pharmacy(String pharmacyName) {
        mPharmacyName = pharmacyName;
    }

    public boolean send(Transporter t) {
        Medicine advil = new Medicine("Advil");
        System.out.printf("Sending an %s.%n", advil.getMedicineName());
        return t.goods.add(advil);
    }
}
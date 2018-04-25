//Java files for globals defined

package android.onlinecooliesystem;

import android.app.Application;

public class Globals extends Application {

    private int rate;
    private double price_for_F_G;
    private int wt_in_KGs;
    private int trolley_fare;
    private static int nmbr_of_trolleys=20;


    public int getRate() {
        return rate;
    }

    public double getPrice_for_F_G() {
        return price_for_F_G;
    }

    public int getWt_in_KGs() {
        return wt_in_KGs;
    }

    public int getTrolley_fare() {
        return trolley_fare;
    }

    public int getNmbr_of_trolleys() {
        return nmbr_of_trolleys;
    }


    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setPrice_for_F_G(double price_for_F_G) {
        this.price_for_F_G = price_for_F_G;
    }

    public void setWt_in_KGs(int wt_in_KGs) {
        this.wt_in_KGs = wt_in_KGs;
    }

    public void setTrolley_fare(int trolley_fare) {
        this.trolley_fare = trolley_fare;
    }

    public void setNmbr_of_trolleys(int nmbr_of_trolleys) {
        this.nmbr_of_trolleys = nmbr_of_trolleys;
    }
}

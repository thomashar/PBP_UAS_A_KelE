package pbp.projectuts;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.text.ParseException;
import java.util.Date;

public class ViewModel extends BaseObservable {
    private User user;

    @Bindable
    public int getUserId(){return user.getId();}

    public void setUserId(int id) {
        user.setId(id);
        notifyPropertyChanged(BR.id);
    }


    @Bindable
    public String getUserNama() {
        return user.getNama();
    }

    public void setUserNama(String nama) {
        user.setNama(nama);
        notifyPropertyChanged(BR.nama);
    }

    @Bindable
    public String getUserTelp() {
        return user.getTelp();
    }

    public void setUserTelp(String telp) {
        user.setTelp(telp);
        notifyPropertyChanged(BR.telp);
    }

    @Bindable
    public int getUserHarga() {
        return user.getHarga();
    }

    public void setUserHarga(int harga) {
        user.setHarga(harga);
        notifyPropertyChanged(BR.harga);
    }

    @Bindable
    public String getUserStringHarga() {
        return String.valueOf(user.getStringHarga());
    }

    public void setUserStringHarga(String harga) {
        if(!harga.isEmpty()){
            user.setStringHarga(harga);
        } else {
            user.setStringHarga(null);
        }
        notifyPropertyChanged(BR.harga);
    }

    @Bindable
    public double getUserBerat() {
        return user.getBerat();
    }

    public void setUserBerat(int berat) {
        user.setBerat(berat);
        notifyPropertyChanged(BR.berat);
    }

    @Bindable
    public String getUserStringBerat() { return String.valueOf(user.getStringBerat()); }

    public void setUserStringBerat(String berat) {
        if(!berat.isEmpty()){
            user.setStringBerat(berat);
        } else {
            user.setStringBerat(null);
        }
        notifyPropertyChanged(BR.berat);
    }

    @Bindable
    public String getUserTglOrder() { return user.getTglOrder(); }

    public void setUserTglOrder(String tglOrder) {
        user.setTglOrder(tglOrder);
        notifyPropertyChanged(BR.tglOrder);
    }

    @Bindable
    public Date getUserDateOrder() throws ParseException { return user.getDateOrder(); }

    public void setUserDateOrder(Date tglOrder) throws ParseException {
        if(tglOrder != null){
            user.setDateOrder(tglOrder);
        } else {
            user.setDateOrder(null);
        }
        notifyPropertyChanged(BR.tglOrder);
    }

    @Bindable
    public String getUserTglAmbil() {
        return user.getTglAmbil();
    }

    public void setUserTglAmbil(String tglAmbil) {
        user.setTglAmbil(tglAmbil);
        notifyPropertyChanged(BR.tglAmbil);
    }

    @Bindable
    public Date getUserDateAmbil() throws ParseException { return user.getDateAmbil(); }

    public void setUserDateAmbil(Date tglAmbil) throws ParseException {
        if(tglAmbil != null){
            user.setDateAmbil(tglAmbil);
        } else {
            user.setDateAmbil(null);
        }
        notifyPropertyChanged(BR.tglAmbil);
    }

    @Bindable
    public String getUserStatus() {
        return user.getStatus();
    }

    public void setUserStatus(String status) {
        user.setStatus(status);
        notifyPropertyChanged(BR.status);
    }
}
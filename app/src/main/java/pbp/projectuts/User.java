package pbp.projectuts;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class User extends BaseObservable implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "telp")
    public String telp;

    @ColumnInfo(name = "harga")
    public int harga;

    @ColumnInfo(name = "berat")
    public double berat;

    @ColumnInfo(name = "tglOrder")
    public Date tglOrder;

    @ColumnInfo(name = "tglAmbil")
    public Date tglAmbil;

    @ColumnInfo(name = "status")
    public String status;

    public User() { }

    public User(String nama, String telp, int harga, double berat,
                Date tglOrder, Date tglAmbil, String status)
    {
        this.nama = nama;
        this.telp = telp;
        this.harga = harga;
        this.berat = berat;
        this.tglOrder = tglOrder;
        this.tglAmbil = tglAmbil;
        this.status = status;
    }

    @Bindable
    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) { this.nama = nama; }

    @Bindable
    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) { this.telp = telp; }

    @Bindable
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) { this.harga = harga; }

    @Bindable
    public String getStringHarga() {
        return String.valueOf(harga);
    }

    public void setStringHarga(String harga) {
        if(!harga.isEmpty()){
            this.harga = Integer.parseInt(harga);
        } else {
            this.harga = 0;
        }
    }

    @Bindable
    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) { this.berat = berat; }

    @Bindable
    public String getStringBerat() { return String.valueOf(berat); }

    public void setStringBerat(String berat) {
        if(!berat.isEmpty()){
            this.berat = Integer.parseInt(berat);
        } else {
            this.berat = 0;
        }
    }

    @Bindable
    public Date getTglOrder() {
        return tglOrder;
    }

    public void setTglOrder(Date tglOrder) { this.tglOrder = tglOrder; }

    @Bindable
    public String getStringOrder() { return String.valueOf(tglOrder); }

    public void setStringOrder(String tglOrder) throws ParseException {
        if(!tglOrder.isEmpty()){
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(tglOrder);
            this.tglOrder = (date1);
        } else {
            this.tglOrder = null;
        }
    }

    @Bindable
    public Date getTglAmbil() {
        return tglAmbil;
    }

    public void setTglAmbil(Date tglAmbil) { this.tglAmbil = tglAmbil; }

    @Bindable
    public String getStringAmbil() { return String.valueOf(tglAmbil); }

    public void setStringAmbil(String tglAmbil) throws ParseException {
        if(!tglAmbil.isEmpty()){
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(tglAmbil);
            this.tglAmbil = (date1);
        } else {
            this.tglAmbil = null;
        }
    }

    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }
}

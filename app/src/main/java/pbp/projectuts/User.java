package pbp.projectuts;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.DateFormat;
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
    public String tglOrder;

    @ColumnInfo(name = "tglAmbil")
    public String tglAmbil;

    @ColumnInfo(name = "status")
    public String status;

    public User() { }

    public User(String nama, String telp, int harga, double berat,
                String tglOrder, String tglAmbil, String status)
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
    public String getTglOrder() {
        return tglOrder;
    }

    public void setTglOrder(String tglOrder) { this.tglOrder = tglOrder; }

    @Bindable
    public Date getDateOrder() throws ParseException {
        Date dateOrder= new SimpleDateFormat("dd/MM/yyyy").parse(tglOrder);
        return dateOrder;
    }

    public void setDateOrder(Date tglOrder) throws ParseException {
        if(tglOrder != null){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dateOrder = df.format(tglOrder);
            this.tglOrder = dateOrder;
        } else {
            this.tglOrder = null;
        }
    }

    @Bindable
    public String getTglAmbil() {
        return tglAmbil;
    }

    public void setTglAmbil(String tglAmbil) { this.tglAmbil = tglAmbil; }

    @Bindable
    public Date getDateAmbil() throws ParseException {
        Date dateAmbil = new SimpleDateFormat("dd/MM/yyyy").parse(tglAmbil);
        return dateAmbil;
    }

    public void setDateAmbil(Date tglAmbil) throws ParseException {
        if(tglAmbil != null){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dateAmbil = df.format(tglAmbil);
            this.tglAmbil = dateAmbil;
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

package fpoly.trungtdph27790.lab1_firebase.lab5;

public class sanpham {
    private String maSp,tenSp,mota ;

    public sanpham() {
    }

    public sanpham(String maSp, String tenSp, String mota) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.mota = mota;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}


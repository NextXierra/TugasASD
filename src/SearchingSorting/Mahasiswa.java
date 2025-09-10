package SearchingSorting;

/**
 * @author Xierra
 */

public class Mahasiswa {
    String nim;
    String nama;
    String IPK;
    
    public Mahasiswa(String nim, String nama, String IPK) {
        this.nim = nim;
        this.nama = nama;
        this.IPK = IPK;
    }
    
    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getIPK(){
        return IPK;
    }
}

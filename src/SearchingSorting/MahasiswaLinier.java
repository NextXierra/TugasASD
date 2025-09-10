package SearchingSorting;
import java.util.Scanner;

/**
 * @author Xierra
 */

public class MahasiswaLinier {
    
    public static int linearSearch(Mahasiswa[] mahasiswa, String targetNim) {
        for (int i = 0; i < mahasiswa.length; i++) {
            if (mahasiswa[i].getNim().equals(targetNim)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Mahasiswa[] mahasiswa = {
            new Mahasiswa("2411016210005", "Muhammad Erge Fakhreza Nasution", ""),
            new Mahasiswa("2411016210013", "Ahmadiansyah", ""),
            new Mahasiswa("2411016110004", "Mochammad Dhafin Dzimar Saputra", ""),
            new Mahasiswa("2411016210003", "Andi Dermawan", ""),
            new Mahasiswa("2411016210017", "Moh. Auffa Maulana", ""),
            new Mahasiswa("2411016310013", "Muhammad Khairi Amrullah", "")
        };
        
        System.out.print("Masukkan NIM yang dicari: ");
        String targetNim = scanner.nextLine();
        
        int hasil = linearSearch(mahasiswa, targetNim);
        
        if (hasil != -1) {
            System.out.println("Data ditemukan!");
            System.out.println(mahasiswa[hasil].getNim() + " - " + mahasiswa[hasil].getNama());
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }
}

package SearchingSorting;
import java.util.Scanner;

/**
 * @author Xierra
 */

public class MahasiswaBinaryJump {
    
    public static int jumpSearch(Mahasiswa[] mahasiswa, String targetNim) {
        int n = mahasiswa.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (mahasiswa[Math.min(step, n)-1].getNim().compareTo(targetNim) < 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) return -1;
        }

        while (mahasiswa[prev].getNim().compareTo(targetNim) < 0) {
            prev++;
            if (prev == Math.min(step, n)) return -1;
        }

        return mahasiswa[prev].getNim().equals(targetNim) ? prev : -1;
    }
    

    public static int binarySearch(Mahasiswa[] mahasiswa, String targetNim) {
        int left = 0, right = mahasiswa.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mahasiswa[mid].getNim().equals(targetNim)) return mid;
            if (mahasiswa[mid].getNim().compareTo(targetNim) < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        
        Mahasiswa[] mahasiswa = {
            new Mahasiswa("22001", "Andi", "3.50"),
            new Mahasiswa("22003", "Budi", "3.20"),
            new Mahasiswa("22005", "Citra", "3.75"),
            new Mahasiswa("22007", "Dedi", "3.10"),
            new Mahasiswa("22009", "Erika", "3.40")
        };
        System.out.print("Masukkan NIM yang dicari: ");
        String targetNim = scanner.nextLine();
        
        int hasilJump = jumpSearch(mahasiswa, targetNim);
        if (hasilJump != -1) {
            System.out.println("Data ditemukan dengan Jump Search: NIM: " + mahasiswa[hasilJump].getNim() + ", Nama: " + mahasiswa[hasilJump].getNama() + ", IPK: " + mahasiswa[hasilJump].getIPK());
        } else {
            System.out.println("Data tidak ditemukan dengan Jump Search");
        }

        int hasilBinary = binarySearch(mahasiswa, targetNim);
        if (hasilBinary != -1) {
            System.out.println("Data ditemukan dengan Binary Search: NIM: " + mahasiswa[hasilBinary].getNim() + ", Nama: " + mahasiswa[hasilBinary].getNama() + ", IPK: " + mahasiswa[hasilBinary].getIPK());
        } else {
            System.out.println("Data tidak ditemukan dengan Binary Search");
        }
    }
}

package SearchingSorting;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Xierra
 * Edisi Salah baca Soal kirain harus array Objek
 */

class mie{
    String nama;
    int harga;

    mie(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama(){
        return nama;
    }

    public int getHarga(){
        return harga;
    }
}

public class Warmindo {
    public static void sortInsertion(ArrayList<mie> mieList) {
        ArrayList<mie> tempList = new ArrayList<>(mieList);
        int n = tempList.size();
        int totalIterasi = 0;
        int totalSwap = 0;
        int totalComparasi = 0;
        
        System.out.println("\nProses Insertion Sort");
        
        for (int i = 1; i < n; i++) {
            totalIterasi++;
            mie key = tempList.get(i);
            int j = i - 1;
            
            System.out.println("\nIterasi " + totalIterasi + ":");
            System.out.println("Key: " + key.getNama() + " (Harga: " + key.getHarga() + ")");
            
            while (j >= 0 && tempList.get(j).getHarga() > key.getHarga()) {
                totalComparasi++;
                System.out.println("Swap: " + tempList.get(j).getNama() + " dengan " + key.getNama());
                tempList.set(j + 1, tempList.get(j));
                totalSwap++;
                j = j - 1;
            }
            
            if (j >= 0) {
                totalComparasi++; 
            }
            
            tempList.set(j + 1, key);
            
            System.out.print("Array setelah iterasi " + totalIterasi + ": ");
            for (int k = 0; k < tempList.size(); k++) {
                System.out.print(tempList.get(k).getNama() + "(" + tempList.get(k).getHarga() + ")");
                if (k < tempList.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.println("\nHasil Insertion Sort:");
        System.out.println("Total Iterasi: " + totalIterasi);
        System.out.println("Total Swap (Move): " + totalSwap);
        System.out.println("Total Comparasi: " + totalComparasi);
        
        System.out.println("\nVarian mie setelah diurutkan berdasarkan harga (Insertion Sort):");
        for (mie m : tempList) {
            System.out.println("Nama: " + m.getNama() + ", Harga: " + m.getHarga());
        }
    }
    
    public static void sortBubble(ArrayList<mie> mieList) {
        ArrayList<mie> tempList = new ArrayList<>(mieList);
        int n = tempList.size();
        int totalIterasi = 0;
        int totalSwap = 0;
        int totalComparasi = 0;
        
        System.out.println("\nProses Bubble Sort");
        
        for (int i = 0; i < n-1; i++) {
            totalIterasi++;
            System.out.println("\nIterasi " + totalIterasi + ":");
            for (int j = 0; j < n-i-1; j++) {
                totalComparasi++;
                if (tempList.get(j).getHarga() > tempList.get(j+1).getHarga()) {
                    System.out.println("Swap: " + tempList.get(j).getNama() + " dengan " + tempList.get(j+1).getNama());
                    mie temp = tempList.get(j);
                    tempList.set(j, tempList.get(j+1));
                    tempList.set(j+1, temp);
                    totalSwap++;
                }
            }
            System.out.print("Array setelah iterasi " + totalIterasi + ": ");
            for (int k = 0; k < tempList.size(); k++) {
                System.out.print(tempList.get(k).getNama() + "(" + tempList.get(k).getHarga() + ")");
                if (k < tempList.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.println("\nHasil Bubble Sort:");
        System.out.println("Total Iterasi: " + totalIterasi);
        System.out.println("Total Swap: " + totalSwap);
        System.out.println("Total Comparasi: " + totalComparasi);
        
        System.out.println("\nVarian mie setelah diurutkan berdasarkan harga (Bubble Sort):");
        for (mie m : tempList) {
            System.out.println("Nama: " + m.getNama() + ", Harga: " + m.getHarga());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<mie> mieList = new ArrayList<>();

        System.out.print("Masukkan jumlah varian mie: ");
        int jumlahVarian = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<jumlahVarian; i++){
            System.out.print("Masukkan nama varian mie ke-" + (i+1) + ": ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan harga varian mie ke-" + (i+1) + ": ");
            int harga = scanner.nextInt();
            scanner.nextLine();
            mieList.add(new mie(nama, harga));
        }
        
        System.out.println("\nVarian mie sebelum diurutkan:");
        for(mie m : mieList){
            System.out.println("Nama: " + m.getNama() + ", Harga: " + m.getHarga());
        }

        do{
            System.out.println("\nPilih metode pengurutan:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Bubble Sort");
            System.out.println("3. 1 dan 2 Benar");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan (1/2/3/4): ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) sortInsertion(mieList);
            else if (pilihan == 2) sortBubble(mieList);
            else if (pilihan == 3) {
                sortInsertion(mieList);
                sortBubble(mieList);
            }
            else if (pilihan == 4) break;
            System.out.println();
        }while(true);
    }

}

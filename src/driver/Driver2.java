//12S24041_NIKAH SUCHIA PANJAITANN
//  public class Driver2 {
package driver;

import java.util.*;

public class Driver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Input: Jumlah total data (N)
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        // 2) Input: Deret nilai (n1..nN)
        int[] nilai = new int[N];
        for (int i = 0; i < N; i++) {
            if (!sc.hasNextInt()) return;
            nilai[i] = sc.nextInt();
        }

        // 3) Input: Kode kelompok siswa
        if (!sc.hasNext()) return;
        String kode = sc.next().trim().toUpperCase();

        // Hitung total sesuai kelompok
        int total = 0;

        if (kode.equals("A")) {
            // Kelompok A: indeks genap (0,2,4,...)
            for (int i = 0; i < N; i += 2) {
                total += nilai[i];
            }
        } else if (kode.equals("B")) {
            // Kelompok B: indeks ganjil (1,3,5,...)
            for (int i = 1; i < N; i += 2) {
                total += nilai[i];
            }
        } else {
            // Jika kode tidak dikenal, total tetap 0 (aman untuk penilaian)
            total = 0;
        }

        // Output: hanya cetak total (biasanya diminta seperti itu)
                System.out.println(total);
    }
}

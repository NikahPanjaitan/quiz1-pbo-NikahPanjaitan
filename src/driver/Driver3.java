//12S24041_NIKAH SUCHIA PANJAITAN 
// public class Driver3 {
package driver;

import java.util.*;

public class Driver3 {

    // Biaya (sesuai info)
    static final int BIAYA_BULANAN_MHS = 40_000;
    static final int BIAYA_KANTONG = 25_000;

    // Info umum (sesuai edaran)
    static final String LOKASI = "Rusun-1 bagian belakang (Gedung baru)";
    static final String MASA_PENYESUAIAN = "1 - 11 November 2023";
    static final String KUOTA = "25% dari total mahasiswa (ditetapkan Pembina Asrama)";
    static final String PEMBAYARAN = "Pendaftaran & pembayaran digabung dengan bursar setiap bulan";
    static final String KONTAK_CS = "CS Laundry Yayasan Del: 088708637308";
    static final String JAM_OPERASIONAL = "08.00 - 17.00 WIB";

    // Data jadwal (dari tabel gambar)
    static class Jadwal {
        String tanggal;
        String asrama;
        String jumlah;
        String hariJemput;
        String jamJemput;
        String titikJemput;
        String hariAntar;
        String jamAntar;
        String titikAntar;

        Jadwal(String tanggal, String asrama, String jumlah,
               String hariJemput, String jamJemput, String titikJemput,
               String hariAntar, String jamAntar, String titikAntar) {
            this.tanggal = tanggal;
            this.asrama = asrama;
            this.jumlah = jumlah;
            this.hariJemput = hariJemput;
            this.jamJemput = jamJemput;
            this.titikJemput = titikJemput;
            this.hariAntar = hariAntar;
            this.jamAntar = jamAntar;
            this.titikAntar = titikAntar;
        }
    }

    static List<Jadwal> buatJadwal() {
        List<Jadwal> list = new ArrayList<>();

        list.add(new Jadwal("02/11/23", "Rusun 1, Silo", "40 orang / 110 orang",
                "Kamis", "06.30", "Selasar Tengah Lantai 1",
                "Kamis", "18.00", "Selasar Tengah Lantai 1"));

        list.add(new Jadwal("03/11/23", "Rusun 2", "150 orang",
                "Jumat", "06.30", "Teras Asrama",
                "Jumat", "18.00", "Selasar Asrama Lantai 1"));

        list.add(new Jadwal("06/11/23", "Rusun 3", "150 orang",
                "Senin", "06.30", "Selasar Tengah Lantai 1",
                "Senin", "18.00", "Ruang Kaca"));

        list.add(new Jadwal("07/11/23", "Rusun 4", "150 orang",
                "Selasa", "06.30", "Selasar Tengah Lantai 1",
                "Selasa", "18.00", "Selasar Tengah Lantai 1"));

        list.add(new Jadwal("09/11/23", "Jati, Kapernaum", "40 orang / 110 orang",
                "Kamis", "06.30", "Teras Asrama",
                "Kamis", "18.00", "Selasar Tengah Lantai 1"));

        list.add(new Jadwal("10/11/23", "Pniel", "150 orang",
                "Jumat", "06.30", "Teras Asrama",
                "Jumat", "18.00", "Selasar Asrama Lantai 1"));

        return list;
    }

    static void tampilkanInfoUmum() {
        System.out.println("=== Informasi Laundry Del ===");
        System.out.println("Lokasi            : " + LOKASI);
        System.out.println("Masa penyesuaian  : " + MASA_PENYESUAIAN);
        System.out.println("Kuota layanan     : " + KUOTA);
        System.out.println("Pembayaran        : " + PEMBAYARAN);
        System.out.println("Jam operasional   : " + JAM_OPERASIONAL);
        System.out.println("Kontak CS         : " + KONTAK_CS);
        System.out.println();
    }

    static void tampilkanJadwal(List<Jadwal> jadwal) {
        System.out.println("=== Jadwal Laundry Masa Penyesuaian (1-11 Nov 2023) ===");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-9s | %-18s | %-16s | %-5s %-5s | %-22s | %-5s %-5s | %-22s%n",
                "Tanggal", "Asrama", "Jumlah", "Hari", "Jam", "Titik Jemput", "Hari", "Jam", "Titik Antar");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (Jadwal j : jadwal) {
            System.out.printf("%-9s | %-18s | %-16s | %-5s %-5s | %-22s | %-5s %-5s | %-22s%n",
                    j.tanggal, j.asrama, j.jumlah,
                    j.hariJemput, j.jamJemput, j.titikJemput,
                    j.hariAntar, j.jamAntar, j.titikAntar);
        }

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("NB: Laundry bisa diantar di hari H penjemputan.");
        System.out.println();
    }

    static void hitungBiaya(Scanner sc) {
        System.out.println("=== Hitung Biaya Laundry Mahasiswa ===");
        System.out.println("Biaya bulanan mahasiswa : Rp " + BIAYA_BULANAN_MHS);
        System.out.println("Biaya kantong laundry   : Rp " + BIAYA_KANTONG + " / pcs");
        System.out.print("Masukkan jumlah kantong yang dibeli/diganti (pcs): ");

        int pcs = 0;
        try {
            pcs = Integer.parseInt(sc.nextLine().trim());
            if (pcs < 0) pcs = 0;
        } catch (Exception e) {
            pcs = 0;
        }

        int total = BIAYA_BULANAN_MHS + (pcs * BIAYA_KANTONG);
        System.out.println("Total bayar bulan ini   : Rp " + total);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Jadwal> jadwal = buatJadwal();

        while (true) {
            System.out.println("=== Sistem Sederhana Laundry Del (T03) ===");
            System.out.println("1. Tampilkan informasi umum laundry");
            System.out.println("2. Tampilkan jadwal laundry");
            System.out.println("3. Hitung biaya mahasiswa (40k + kantong)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String pilih = sc.nextLine().trim();

            if (pilih.equals("1")) {
                tampilkanInfoUmum();
            } else if (pilih.equals("2")) {
                tampilkanJadwal(jadwal);
            } else if (pilih.equals("3")) {
                hitungBiaya(sc);
            } else if (pilih.equals("0")) {
                System.out.println("Keluar. Terima kasih.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }
    }
}


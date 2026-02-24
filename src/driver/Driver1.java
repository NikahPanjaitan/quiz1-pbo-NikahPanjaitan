//12S24041_NIKAH SUCHIA PANJAITAN
package driver;

import java.util.*;

public class Driver1 {

    static class MenuItem {
        String kode;
        String nama;
        int harga;

        MenuItem(String kode, String nama, int harga) {
            this.kode = kode;
            this.nama = nama;
            this.harga = harga;
        }
    }

    static class LineItem {
        MenuItem menu;
        int porsiGabungan; // Butet + Ucok

        LineItem(MenuItem menu, int porsiGabungan) {
            this.menu = menu;
            this.porsiGabungan = porsiGabungan;
        }

        int total() {
            return menu.harga * porsiGabungan;
        }
    }

    public static void main(String[] args) {
        Map<String, MenuItem> menuMap = new HashMap<>();
        menuMap.put("NGS", new MenuItem("NGS", "Nasi Goreng Spesial", 15000));
        menuMap.put("AP",  new MenuItem("AP",  "Ayam Penyet", 20000));
        menuMap.put("SA",  new MenuItem("SA",  "Sate Ayam (10 Tusuk)", 25000));
        menuMap.put("BU",  new MenuItem("BU",  "Bakso Urat", 18000));
        menuMap.put("MAP", new MenuItem("MAP", "Mie Ayam Pangsit", 15000));
        menuMap.put("GG",  new MenuItem("GG",  "Gado-Gado", 15000));
        menuMap.put("SAM", new MenuItem("SAM", "Soto Ayam", 17000));
        menuMap.put("RD",  new MenuItem("RD",  "Rendang Daging", 25000));
        menuMap.put("IB",  new MenuItem("IB",  "Ikan Bakar", 35000));
        menuMap.put("NUK", new MenuItem("NUK", "Nasi Uduk Komplit", 20000));

        Scanner sc = new Scanner(System.in);

        // agar urutan sesuai input pertama muncul
        Map<String, Integer> porsiGabunganPerKode = new LinkedHashMap<>();

        while (true) {
            if (!sc.hasNextLine()) break;
            String kode = sc.nextLine().trim();

            if (kode.isEmpty()) continue;

            if (kode.equalsIgnoreCase("END")) break;

            if (!menuMap.containsKey(kode)) {
                // skip 1 baris porsi jika kode tidak dikenal
                if (sc.hasNextLine()) sc.nextLine();
                continue;
            }

            if (!sc.hasNextLine()) break;
            String porsiStr = sc.nextLine().trim();

            int porsiButet;
            try {
                porsiButet = Integer.parseInt(porsiStr);
            } catch (NumberFormatException e) {
                continue;
            }

            // Ucok = 2 * Butet => total porsi gabungan = 3 * porsiButet
            int porsiGabungan = 3 * porsiButet;

            porsiGabunganPerKode.put(
                    kode,
                    porsiGabunganPerKode.getOrDefault(kode, 0) + porsiGabungan
            );
        }

        List<LineItem> items = new ArrayList<>();
        int totalBelanja = 0;

        for (Map.Entry<String, Integer> e : porsiGabunganPerKode.entrySet()) {
            MenuItem m = menuMap.get(e.getKey());
            LineItem li = new LineItem(m, e.getValue());
            items.add(li);
            totalBelanja += li.total();
        }

        printStrukT01(items, totalBelanja);
    }

    // Output persis gaya contoh: garis "=" dan hanya Total Pembayaran
    static void printStrukT01(List<LineItem> items, int totalBelanja) {
        String line = "==============================================================";

        // Header (mirip contoh)
        System.out.printf("%-22s %5s %10s %10s%n", "Menu", "Porsi", "Harga", "Total");
        System.out.println(line);

        for (LineItem li : items) {
            System.out.printf(
                    "%-22s %5d %10d %10d%n",
                    li.menu.nama,
                    li.porsiGabungan,
                    li.menu.harga,
                    li.total()
            );
        }

        System.out.println(line);

        // Di contoh, hanya ada "Total Pembayaran"
        System.out.printf("%-22s %27d%n", "Total Pembayaran", totalBelanja);
    }
}
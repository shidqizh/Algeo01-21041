import java.util.Scanner;

import Aplikasi.Menu;


public class main {
    public static void main(String[] agrs) {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        int pil;
        boolean aktif = true;
        System.out.println("==================== Program Mulai ====================");
        while (aktif){
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic\n6. Regresi linier berganda\n7. Keluar");
            System.out.println("Pilihan: ");
            pil = scan.nextInt();
            if (pil != 7) {
                menu.pilihan(pil);
                System.out.println("==================== SELESAI ====================");
            }
            else {
                aktif = false;
            }
        }
        System.out.println("==================== Program Tutup ====================");
        scan.close();
    }
}

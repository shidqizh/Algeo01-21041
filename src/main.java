import Matrix.*;

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
            menu.list();
            System.out.println("Pilihan:");
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

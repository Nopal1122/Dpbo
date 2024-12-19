/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book_donation;
import Book.*;
import java.util.Scanner;

/**
 *
 * @author Irfan Rangga
 */
public class PenerimaDashboard {
    public static void menuPenerima(int donaturId) {
        IBookService book = new BookService();
        Scanner sc = new Scanner(System.in);
        
        printMenuPenerima();
        int opsi = sc.nextInt();
        while(opsi != 4){
            switch(opsi){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }
    
    public static void printMenuPenerima(){
        System.out.println("=== Menu Penerima ===");
        System.out.println("1. Lihat semua list buku");
        System.out.println("2. Cari buku");
        System.out.println("3. Ajukan Permintaan");
        System.out.println("4. Keluar");
        System.out.println("Pilih opsi (1/2/3/4): ");
    }
}

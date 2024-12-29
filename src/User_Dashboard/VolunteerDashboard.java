<<<<<<< HEAD:src/book_donation/VolunteerDashboard.java
package book_donation;

import Book.BookService;
import Book.Book;
import java.util.Scanner;
import java.util.List;

public class VolunteerDashboard {

    public static void volunteerMenu() {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();

        while (true) {
            System.out.println("\n=== Dashboard Volunteer ===");
            System.out.println("1. Lihat Buku yang Belum Diverifikasi");
            System.out.println("2. Verifikasi Buku");
            System.out.println("3. Buat laporan");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                // Tampilkan buku yang belum diverifikasi
                List<Book> unverifiedBooks = bookService.getUnverifiedBooks();
                if (unverifiedBooks.isEmpty()) {
                    System.out.println("Tidak ada buku yang perlu diverifikasi.");
                } else {
                    System.out.println("\n=== Buku yang Belum Diverifikasi ===");
                    for (Book book : unverifiedBooks) {
                        System.out.println("ID: " + book.getIdBuku());
                        System.out.println("Judul: " + book.getJudul());
                        System.out.println("Donatur ID: " + book.getDonaturId());
                        System.out.println("--------------------------------");
                    }
                }
            } else if (pilihan == 2) {
                // Verifikasi buku
                System.out.print("Masukkan ID buku yang akan diverifikasi: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                if (bookService.verifyBook(bookId)) {
                    System.out.println("Buku berhasil diverifikasi.");
                } else {
                    System.out.println("Gagal memverifikasi buku. Pastikan ID buku valid.");
                }
            } else if (pilihan == 3) {
                break;
            } else {
                System.out.println("Opsi tidak valid.");
            }
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User_Dashboard;
import java.util.Scanner;

/**
 *
 * @author Irfan Rangga
 */
public class VolunteerDashboard {
    public static void volunteerMenu(){
        Scanner sc = new Scanner(System.in);
        int opsi = 0;
        
        while(opsi != 4){
            System.out.println("\n=== Halaman Utama Volunteer ===");
            System.out.println("1. Validasi Buku dari Donatur");
            System.out.println("2. Distribusi Buku");
            System.out.println("3. Buat Laporan");
            System.out.println("4. Logout");
            System.out.print("Pilih opsi: ");
            opsi = sc.nextInt();

>>>>>>> 395b64894f5089ed05c5c18a51b60f0f5d3d2e47:src/User_Dashboard/VolunteerDashboard.java
        }
    }
}

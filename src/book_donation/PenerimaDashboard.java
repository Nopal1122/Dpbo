package book_donation;

import Book.Book;
import Book.IBookService;
import Book.BookService;
import java.util.List;
import java.util.Scanner;
import User.Penerima;

public class PenerimaDashboard {

    public static void penerimaMenu(Penerima penerima) {
        Scanner scanner = new Scanner(System.in);
        IBookService bookService = new BookService(); // Gunakan interface

        while (true) {
            System.out.println("\n=== Halaman Utama Penerima ===");
            System.out.println("1. Lihat Semua Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Pesan Buku");
            System.out.println("4. Logout");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                // Lihat semua buku
                System.out.println("\n=== Daftar Buku yang Tersedia ===");
                List<Book> books = bookService.getAllBooksByDonatur(0); // 0 untuk semua donatur
                if (books.isEmpty()) {
                    System.out.println("Tidak ada buku yang tersedia saat ini.");
                } else {
                    for (Book book : books) {
                        System.out.println("-----------------------------------");
                        System.out.println("ID Buku: " + book.getIdBuku());
                        System.out.println("Judul: " + book.getJudul());
                        System.out.println("Penulis: " + book.getPenulis());
                        System.out.println("Penerbit: " + book.getPenerbit());
                        System.out.println("Kondisi: " + book.getKondisi());
                        System.out.println("-----------------------------------");
                    }
                }

            } else if (pilihan == 2) {
                // Cari buku
                System.out.println("\n=== Cari Buku ===");
                System.out.print("Masukkan judul buku: ");
                String judulBuku = scanner.nextLine();

                List<Book> books = bookService.getAllBooksByDonatur(0);
                boolean found = false;
                for (Book book : books) {
                    if (book.getJudul().equalsIgnoreCase(judulBuku)) {
                        System.out.println("-----------------------------------");
                        System.out.println("ID Buku: " + book.getIdBuku());
                        System.out.println("Judul: " + book.getJudul());
                        System.out.println("Penulis: " + book.getPenulis());
                        System.out.println("Penerbit: " + book.getPenerbit());
                        System.out.println("Kondisi: " + book.getKondisi());
                        System.out.println("-----------------------------------");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Buku dengan judul \"" + judulBuku + "\" tidak ditemukan.");
                }

            } else if (pilihan == 3) {
                // Pesan buku
                System.out.println("\n=== Pesan Buku ===");
                System.out.print("Masukkan ID buku yang ingin dipesan: ");
                int idBuku = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Book book = bookService.getBookById(idBuku);
                if (book != null) {
                    System.out.println("\n=== Invoice ===");
                    System.out.println("ID Penerima: " + penerima.getId());
                    System.out.println("Nama: " + penerima.getNama());
                    System.out.println("Judul Buku: " + book.getJudul());
                    System.out.println("Penulis: " + book.getPenulis());
                    System.out.println("Penerbit: " + book.getPenerbit());
                    System.out.println("-----------------------------------");
                    System.out.println("Buku berhasil dipesan!");
                } else {
                    System.out.println("Buku dengan ID " + idBuku + " tidak ditemukan.");
                }

            } else if (pilihan == 4) {
                System.out.println("Logout berhasil. Kembali ke menu utama.");
                break;

            } else {
                System.out.println("Opsi tidak valid.");
            }
        }
    }
}

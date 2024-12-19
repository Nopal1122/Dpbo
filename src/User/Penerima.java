/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;
import Book.*;
import java.util.*;

/**
 *
 * @author Irfan Rangga
 */
public class Penerima extends User{
    private String ulasan;
    private int rating;
    
    public Penerima(int id, String nama, String email, String alamat, String password, String kontak) {
        super(id, nama, email, alamat, password, kontak, "Penerima");
    }
    
    public void ajukanPermintaan(){
        //Input judul buku yang ingin diminta
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan Judul Buku yang ingin diminta");
        System.out.print("Judul Buku: ");
        String judulBuku = sc.nextLine();
        
        //Pengecekan ketersediaan buku yang diminta
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if(judulBuku != books.get(i).getJudul()){
                System.out.println("Buku tidak tersedia.");
            } else {
                // Jika buku tersedia dan masih bisa dipesan
                System.out.println("Berhasil Memesan Buku!");
                System.out.println("=========== INVOICE ===========");
                System.out.println("User ID:\t" + super.getId());
                System.out.println("Nama Pemesan:\t" + super.getNama());
                System.out.println("Judul:\t" + books.get(i).getJudul());
                System.out.println("Penulis:\t" + books.get(i).getPenulis());
                System.out.println("Penerbit:\t" + books.get(i).getPenerbit());
                System.out.println("===============================");
            }
        }
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }
    
    public void beriUlasan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bagaimana pendapatmu tentang buku ini?");
        String review = sc.nextLine();
        if(review == null){
            System.out.println("Masukkan minimal 3 kata!");
            return;
        }
        setUlasan(review);
        System.out.println("Terima Kasih sudah memberikan ulasan");
    }

    @Override
    public String toString() {
        return "Data Penerima{" +
                "\nUser ID:\t\t" + getId() +
                "\nNama Penerima:\t" + getNama() +
                "\nEmail:\t\t" + getEmail() +
                "\nAlaamt:\t\t" + getAlamat() +
                "\nNo. HP:\t\t" + getKontak() +
                '}';
    }
    
    
}

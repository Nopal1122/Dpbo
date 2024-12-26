/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author Irfan Rangga
 */
public class Volunteer extends User{

    public Volunteer(int id, String nama, String email, String alamat, String password, String kontak) {
        super(id, nama, email, alamat, password, kontak, "Volunteer");
    }
    
    public void verifikasiDonasi(){
        //Volunteer bakal ngecek buku yang ada di list
        //Volunteer pilih buku yang mau di verifikasi
        //Jika kondisi buku Baru/Bekas, set kondisi approved -> true
        //Kalo approved = true, tampilin pesan "Verifikasi berhasil"
        //Kalo gagal, tampilin pesan "Verifikasi gagal"
    }
    
    public void laporkanDistribusi(){
        //Volunteer 
    }
    
    @Override
    public String toString(){
         return "Data Volunteer{" +
                "\nUser ID:\t\t" + getId() +
                "\nNama Volunteer:\t" + getNama() +
                "\nEmail:\t\t" + getEmail() +
                "\nAlaamt:\t\t" + getAlamat() +
                "\nNo. HP:\t\t" + getKontak() +
                '}';
    }
}

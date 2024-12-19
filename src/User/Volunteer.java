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
        
    }
    
    public void laporkanDistribusi(){
        
    }
    
    @Override
    public String toString(){
        
    }
}

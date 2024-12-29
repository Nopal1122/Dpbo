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

        }
    }
}

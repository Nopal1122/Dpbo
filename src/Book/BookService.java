package Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class BookService {

    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/book_donation", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

  public boolean addBook(Book book) {
    System.out.println("Memulai proses pengajuan buku oleh donatur ID: " + book.getDonaturId()); // Log ID donatur
    if (!isDonaturValid(book.getDonaturId())) {
        System.out.println("Donatur dengan ID " + book.getDonaturId() + " tidak ditemukan."); // Log jika donatur tidak ditemukan
        return false;
    }

    String sql = "INSERT INTO books (judul, penerbit, genre, penulis, kategori, kondisi, jumlah_buku, donatur_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, book.getJudul());
        stmt.setString(2, book.getPenerbit());
        stmt.setString(3, book.getGenre());
        stmt.setString(4, book.getPenulis());
        stmt.setString(5, book.getKategori());
        stmt.setString(6, book.getKondisi());
        stmt.setInt(7, book.getJumlahBuku());
        stmt.setInt(8, book.getDonaturId());

        System.out.println("Query pengajuan buku: " + stmt); // Log query
        stmt.executeUpdate();
        System.out.println("Buku berhasil diajukan untuk donasi."); // Log sukses pengajuan
        return true;
    } catch (Exception e) {
        System.out.println("Gagal mengajukan buku: " + e.getMessage()); // Log error
        return false;
    }
}


private boolean isDonaturValid(int donaturId) {
    System.out.println("Memeriksa validasi donatur dengan ID: " + donaturId); // Log ID yang diperiksa
    String sql = "SELECT COUNT(*) FROM users WHERE id = ?";
    try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, donaturId);

        ResultSet rs = stmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("Donatur dengan ID " + donaturId + " valid."); // Log valid
            return true;
        } else {
            System.out.println("Donatur dengan ID " + donaturId + " tidak ditemukan."); // Log tidak valid
        }
    } catch (Exception e) {
        System.out.println("Error validasi donatur: " + e.getMessage()); // Log error
    }
    return false;
}
public boolean deleteBook(int bookId, int donaturId) {
    // Validasi apakah buku dimiliki oleh donatur yang sedang login
    if (!isBookOwnedByDonatur(bookId, donaturId)) {
        System.out.println("Buku dengan ID " + bookId + " tidak ditemukan atau bukan milik donatur dengan ID " + donaturId);
        return false;
    }

    String sql = "DELETE FROM books WHERE id = ?";
    try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, bookId);
        stmt.executeUpdate();
        System.out.println("Buku dengan ID " + bookId + " berhasil dihapus.");
        return true;
    } catch (Exception e) {
        System.out.println("Gagal menghapus buku: " + e.getMessage());
        return false;
    }
}

// Validasi apakah buku dimiliki oleh donatur yang sedang login
private boolean isBookOwnedByDonatur(int bookId, int donaturId) {
    String sql = "SELECT COUNT(*) FROM books WHERE id = ? AND donatur_id = ?";
    try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, bookId);
        stmt.setInt(2, donaturId);

        ResultSet rs = stmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("Buku dengan ID " + bookId + " ditemukan untuk donatur ID " + donaturId);
            return true;
        } else {
            System.out.println("Buku dengan ID " + bookId + " tidak ditemukan atau bukan milik donatur ID " + donaturId);
        }
    } catch (Exception e) {
        System.out.println("Error validasi kepemilikan buku: " + e.getMessage());
    }
    return false;
}



}
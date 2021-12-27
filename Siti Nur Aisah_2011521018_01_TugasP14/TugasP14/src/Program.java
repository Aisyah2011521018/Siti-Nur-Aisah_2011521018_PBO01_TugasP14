import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Program {
	static Connection conn;
	
    public static void main(String[] args) {
    	Scanner terimaInput = new Scanner (System.in);
    	String pilihanUser;
    	boolean isLanjutkan = true;
    	
    	String url = "jdbc:mysql://localhost:3306/penggajian_karyawan";
		try {
			
		String salamSapa = "Hallo, Semoga hari mu menyenangkan";
		String sapa = salamSapa.replace("Hallo", "Silahkan gunakan aplikasi ini dengan benar ya!"); 

		System.out.println(sapa.toLowerCase());

		Date datenow = new Date();
		SimpleDateFormat tgl = new SimpleDateFormat("E, dd/MM/yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss zzz");
	

			System.out.println("Tanggal \t: " + tgl.format(datenow));
			System.out.println("Waktu \t\t: " + time.format(datenow));
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","");
			System.out.println("Class Driver ditemukan!!!");
			Gaji gaji = new Gaji();
			
			while (isLanjutkan) {
				System.out.println("======================");
				System.out.println("Database Pegawai");
				System.out.println("======================");
				System.out.println("1. Lihat Data Pegawai");
				System.out.println("2. Tambah Data Pegawai");
				System.out.println("3. Ubah Data Pegawai");
				System.out.println("4. Hapus Data Pegawai");
				System.out.println("5. Cari Data Pegawai");
				
				System.out.print("\nMasukkan pilihan anda (1-5): ");
				pilihanUser = terimaInput.next();
				
				switch (pilihanUser) {
				case "1":
					gaji.menampilkandatabase();
					break;
				case "2":
					gaji.insertdata();
					break;
				case "3":
					gaji.ubahdata();
					break;
				case "4":
					gaji.delete();
					break;
				case "5":
					gaji.searchdata();
					break;
				default:
					System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-5]");
				}
				
				System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
				pilihanUser = terimaInput.next();
				isLanjutkan = pilihanUser.equalsIgnoreCase("y");

			}
			System.out.println("Program selesai");
			
		}
		catch(ClassNotFoundException ex) {
			System.err.println("Driver Error");
			System.exit(0);
		}
		catch(SQLException e){
			System.err.println("Tidak berhasil koneksi");
		}
    }
}

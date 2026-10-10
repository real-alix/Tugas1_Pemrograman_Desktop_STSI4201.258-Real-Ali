import java.util.*;

class Menu {

    String nama;
    int harga;
    String kategori;
    Menu(String nama, int harga, String kategori){
        this.nama= nama; this.harga=harga;this.kategori=kategori;
    }
}

public class Main {
    static Menu[] daftarMenu = new Menu[8];

    //Method 1 : Input data menu
    static void initMenu(){
        daftarMenu[0] = new Menu("Nasi Goreng", 25000, "makanan");
        daftarMenu[1] = new Menu("Ayam geprek", 20000, "makanan");
        daftarMenu[2] = new Menu("Mie goreng", 20000, "makanan");
        daftarMenu[3] = new Menu("Sate Ayam",30000, "makanan");
        daftarMenu[4] = new Menu("Es Teh", 5000, "minuman");
        daftarMenu[5] = new Menu("Es Jeruk",7000, "minuman");
        daftarMenu[6] = new Menu("Air Mineral", 6000, "minuman");
        daftarMenu[7] = new Menu("Kopi Susu", 15000, "minuman");        

    }

    //Method 2 : Tampilkan menu per kategori
    static void tampilkanDaftarMenu(){
        System.out.println("===========DAFTAR MENU=============");
        System.out.println("----MAKANAN------");
        System.out.println(daftarMenu[0].nama+"- Rp"+ daftarMenu[0].harga);
        System.out.println(daftarMenu[1].nama+"- Rp"+ daftarMenu[1].harga);
        System.out.println(daftarMenu[2].nama+"- Rp"+ daftarMenu[2].harga);
        System.out.println(daftarMenu[3].nama+"- Rp"+ daftarMenu[3].harga);
        System.out.println("-----MINUMAN------");
        System.out.println(daftarMenu[4].nama+"- Rp"+ daftarMenu[4].harga);
        System.out.println(daftarMenu[5].nama+"- Rp"+ daftarMenu[5].harga);
        System.out.println(daftarMenu[6].nama+"- Rp"+ daftarMenu[6].harga);
        System.out.println(daftarMenu[7].nama+" - Rp"+ daftarMenu[7].harga);
    }

    //Method 3 : Cari menu (kita pakaI switch func)

    static Menu cariMenu(String nama){
        switch (nama.toLowerCase()) {
            case "nasi goreng": return daftarMenu[0];
            case "ayam geprek": return daftarMenu[1];
            case "mie goreng": return daftarMenu[2];
            case "sate ayam": return daftarMenu[3];
            case "es teh": return daftarMenu[4];
            case "es jeruk": return daftarMenu[5];
            case "air mineral": return daftarMenu[6];  
            case "kopi susu": return daftarMenu[7];                     
            default:return null;
        }
    }

    //Method 4 : Hitung total + pajak + diskon (disini kita pakai IF dan Switch)

    static void cetakStruk(Menu p1, int q1, Menu p2, int q2, Menu p3, int q3, Menu p4, int q4){

        int total = 0;
        if(p1!=null) total+=p1.harga * q1;
        if(p2!=null) total+=p2.harga * q2;
        if(p3!=null) total+=p3.harga * q3;
        if(p4!=null) total+=p4.harga * q4;

        int pajak = total * 10/100;
        int service = 20000;

        // Jika diskon berlaku

        int diskon = 0;

        if(total>100000){
            diskon = total* 10/100;
        }

        //Jika ada bonus (kita pakai Switch)

        Menu gratis = null;

        if (p1!=null) {switch (p1.kategori) {case "minuman": gratis= p1;break;}}
        if (gratis==null&&p2!=null) {switch (p2.kategori) {case "minuman":gratis= p2;break;}}
        if (gratis==null&&p3!=null) {switch (p3.kategori) {case "minuman":gratis= p3;break;}}
        if (gratis==null&&p4!=null) {switch (p4.kategori) {case "minuman":gratis= p4;break;}}

        int bonus = 0;

        if (total>50000 && gratis!=null) {
            bonus = gratis.harga;            
        }

        int bayar = total + pajak + service - diskon - bonus;

        System.out.println("\n=========STRUK=============");
        if (p1!=null) System.out.println(p1.nama+" x "+ q1 + " = Rp" + p1.harga*q1);
        if (p2!=null) System.out.println(p2.nama+" x "+ q2 + " = Rp" + p2.harga*q2);
        if (p3!=null) System.out.println(p3.nama+" x "+ q3 + " = Rp" + p3.harga*q3);
        if (p4!=null) System.out.println(p4.nama+" x "+ q4 + " = Rp" + p4.harga*q4);
        System.out.println("-------------------------------------");
        System.out.println("Total : Rp "+ total);
        System.out.println("Pajak : Rp " + pajak);
        System.out.println("Service : Rp " + service);

        if (diskon>0) System.out.println("Diskon 10% : Rp " + diskon);
        if (bonus>0) System.out.println("Bonus Gratis : Rp "+bonus+"("+gratis.nama+")");
        System.out.println("Total Bayar : Rp "+ bayar);

    }

    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);
        initMenu();
        tampilkanDaftarMenu();

        System.out.println("\nJumlah Jenis (1-4):");
        int j = sc.nextInt(); sc.nextLine();

        Menu p1=null, p2=null, p3=null, p4=null;
        int q1 = 0, q2 = 0, q3 = 0, q4 = 0;

        switch (j) {
            case 4:
                System.out.println("Pesanan 4 (format: nasi goreng = 2) ");
                String[] a4=sc.nextLine().split("="); p4=cariMenu(a4[0].trim()); q4=Integer.parseInt(a4[1].trim());
            case 3:
                System.out.println("Pesanan 3: ");
                String[] a3=sc.nextLine().split("="); p3=cariMenu(a3[0].trim()); q3=Integer.parseInt(a3[1].trim());
            case 2:
                System.out.println("Pesanan 2: ");
                String[] a2=sc.nextLine().split("="); p2=cariMenu(a2[0].trim()); q2=Integer.parseInt(a2[1].trim());
            case 1:
                System.out.println("Pesanan 1: ");
                String[] a1=sc.nextLine().split("="); p1=cariMenu(a1[0].trim()); q1=Integer.parseInt(a1[1].trim());
                break;
        
            default: System.out.println("Harus 1-4"); return;
                
        }

        cetakStruk(p1, q1, p2, q2, p3, q3, p4, q4);
    }

}

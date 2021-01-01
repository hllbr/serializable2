
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ObjeyiOku {
    public static void main(String[] args) {
        //buradada objectınputstream kullanıyoruz
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("ogrenciler.bin"))){
          Ogrenci[] ogrenci_array = (Ogrenci[])in.readObject();
          //Hangi sırayla yazdıysak o sırayla okumamız gerekiyor once ogrenci array yazmıştık burdada aynısı oldu şimdi listeyi yazmamaız gerekiyor
            ArrayList<Ogrenci> ogrenci_list = (ArrayList<Ogrenci>)in.readObject();
            //önce ogrenci array bastırıyoruz
            System.out.println("////////////////////////////////////");
            for(Ogrenci o : ogrenci_array){
                System.out.println(o);
                System.out.println("******************************************");
                Thread.sleep(1500);
               //bir objenin serileştirilebilmesi için mutlaka serilizable interface mutlaka implements etmesi gerekiyor
            }
             System.out.println("////////////////////////////////////");
             for(Ogrenci o: ogrenci_list){
                 System.out.println(o);
                 System.out.println("-----------------------------------------");
             }
        } catch (FileNotFoundException ex) {
            System.out.println("Okunacak Dosya bulunamadı");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken bir ıoexception meydana geldi");
        } catch (ClassNotFoundException ex) {
            System.out.println("Tür Dönüşümü Hatası ");
            System.out.println("Sınıf(Class) bulunamadı");
        } catch (InterruptedException ex) {
            Logger.getLogger(ObjeyiOku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

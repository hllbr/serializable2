
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ObjeyiYaz {
    public static void main(String[] args) {
        //objeyi serileştirmek için objectoutputstream'e ihtiyacımız var
        Ogrenci ogrenci = new Ogrenci("hllbr", 1234, "EEM");
        Ogrenci ogrenci1 = new Ogrenci("h2lbr", 125, "ENGİNEER");
        Ogrenci ogrenci2 = new Ogrenci("PRİNCE", 1235, "DEVELOPER");
        Ogrenci[] ogrenci_array = {ogrenci,ogrenci1,ogrenci2};
        ArrayList<Ogrenci> ogrenci_list = new ArrayList<Ogrenci>(Arrays.asList(ogrenci_array));
        
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ogrenciler.bin"))){
            out.writeObject(ogrenci_array);
            out.writeObject(ogrenci_list);
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken bir sorun meydana geldi");
        }
    }
}

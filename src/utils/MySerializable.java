package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySerializable<T> {

    public MySerializable() { }
    
    public void writeObj(T object, String path) {
        try(ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(path))) {
            outFile.writeObject(object);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MySerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public T readObj(String path) {
        T obj = null;
        try(ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path))) {
            obj = (T)inFile.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MySerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }    
}
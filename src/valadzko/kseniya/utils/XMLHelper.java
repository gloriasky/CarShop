package valadzko.kseniya.utils;

//import org.apache.logging.log4j.LogManager;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLHelper {
    private static final String PATH = "D://Университет/4 семестр/Алгоритмизация и программирование/CarsShopSystem/src/main/java/valadzko/kseniya/resources/cars.xml";
//    private static final Logger LOGGER = LogManager.getLogger(XMLHelper.class.getName());
    public static void writeToXML(List<?> objects){
        try(FileOutputStream fileOS = new FileOutputStream(PATH)){
            XMLEncoder encoder=null;
            encoder=new XMLEncoder(fileOS);
            encoder.writeObject(objects);
            encoder.close();
//            LOGGER.info("file is written");
        }
        catch(FileNotFoundException fileNotFound){
//            LOGGER.error("ERROR: While Creating or Opening the File");
        } catch (IOException e) {
//            LOGGER.error(e.getMessage());
        }
    }
    public static List<?> readFromXML(){
        try(FileInputStream fileIS = new FileInputStream(PATH)){
            XMLDecoder decoder = new XMLDecoder(fileIS);
            List<?> decodedList = (ArrayList<?>) decoder.readObject();
            decoder.close();
//            LOGGER.info("file was read");
            return decodedList;
        } catch (IOException e) {
//            LOGGER.error(e.getMessage());
        }
        return null;
    }
}

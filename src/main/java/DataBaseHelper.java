import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sharikov Pavel on 05.10.2017.
 */
public class DataBaseHelper {

    public static void createNewDataBase() {
        String pathToBase = Handler.HOME_DIR + Handler.props.getProperty("pathToBase");
        System.out.println("Путь до базы данных: " + pathToBase);
        File file = new File(pathToBase);
        try {
            Database tb = new DatabaseBuilder(file)
                    .setFileFormat(Database.FileFormat.V2003)
                    .create();
            System.out.println("База данных создана в дирректории: " + pathToBase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Открываем базу данных по Default Path
     */
    public static void openDataBase() {
        try {
            Handler.openDB = DatabaseBuilder.open(new File(
                    Handler.HOME_DIR + Handler.props.getProperty("pathToBase")));
            System.out.println("База данных " + Handler.openDB.getFileFormat() + " открыта");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Открываем базу данных по пользовательскому пути
     *
     * @param pathToDataBase Путь до необходимой Access базы данных, путь указывается
     *                       вместе с файлом
     */
    public static void openDataBase(String pathToDataBase) {
        try {
            Handler.openDB = DatabaseBuilder.open(new File(
                    Handler.HOME_DIR + pathToDataBase));
            System.out.println("База данных " + Handler.openDB.getFileFormat() + " открыта");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
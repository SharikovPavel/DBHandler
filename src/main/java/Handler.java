import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

import java.util.Properties;

/**
 * Created by Sharikov Pavel on 01.10.2017.
 */
public class Handler {
    public static String HOME_DIR = System.getProperty("user.dir");

    /**
     * Переменная для Общего доступа к DataBase из всех классов, чтобы хранилась на виду
     */
    public static Database DBDefault;

    /**
     * Переменная для хранения отркытой таблицы из вновь открытой Базы данных
     */
    public static Table tableDefault;

    /**
     * Файл настроек проекта
     */
    public static Properties props;
}
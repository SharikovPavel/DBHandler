import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Общий класс для инициализации параметров программы
 * <p>
 * Created by Sharikov Pavel on 05.10.2017.
 */
public class Init {

    private static InputStreamReader isr;
    public static final String PATH_APP_PROPERTIES = Handler.HOME_DIR +
            "/src/main/resources/config.properties";

    /**
     * Метод для чтения параметров config-файла в Properties приложения
     *
     * @throws Exception
     */
    public static void initPropsConfig() throws Exception {
        Handler.props = new Properties();
        try {
            isr = new InputStreamReader(new FileInputStream(new File(PATH_APP_PROPERTIES)),
                    "UTF8");
            Handler.props.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Ошибка. Не удалось прочитать файл конфигураций");
        }
    }

    public static void initDirs() {
        //TODO: Если нет папки base - то создавать ее
    }
}
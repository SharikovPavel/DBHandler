import com.healthmarketscience.jackcess.*;

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
            Handler.DBDefault = DatabaseBuilder.open(new File(
                    Handler.HOME_DIR + Handler.props.getProperty("pathToBase")));
            System.out.println("База данных " + Handler.DBDefault.getFileFormat() + " открыта");
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
            Handler.DBDefault = DatabaseBuilder.open(new File(
                    Handler.HOME_DIR + pathToDataBase));
            System.out.println("База данных " + Handler.DBDefault.getFileFormat() + " открыта");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение определенной таблицы из новой открытой базы данных
     *
     * @param nameTable имя таблицы
     */
    public static void getTableOfNewOpenDB(String nameTable) throws IOException {
        Handler.tableDefault = Handler.DBDefault.getTable(nameTable);
    }

    /**
     * Создание в default базе данных таблицы и столбцов согласно шаблону
     */
    public static void createTableInDataBase() {
        try {
            Handler.tableDefault = new TableBuilder("Offices_and_premises")
                    .addColumn(new ColumnBuilder("Street", DataType.TEXT))
                    .addColumn(new ColumnBuilder("Building", DataType.TEXT))
                    .addColumn(new ColumnBuilder("Floor", DataType.INT))
                    .addColumn(new ColumnBuilder("Room", DataType.INT))
                    .addColumn(new ColumnBuilder("Company_name", DataType.TEXT))
                    .toTable(Handler.DBDefault);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод позволяет добавить строку в таблицу
     *
     * @param contentRow Наполнение ряда
     */
    public static void addRowInTable(Object... contentRow) throws IOException {
        //TODO: Сделать возможность принятия листа
        try {
            Handler.tableDefault.addRow(contentRow);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e.getCause().getMessage());
        }
    }

    /**
     * Метод позволяет вывести все строки таблицы в консоль
     *
     * @throws IOException
     */
    public static void getRowInOpenTable() throws IOException {
        for (Row row : Handler.tableDefault) {
            System.out.println(row);
        }
    }

    /**
     * Метод позволяющий получить любой столбец таблице целиком
     *
     * @param nameColumn
     */
    public static void getColumnInOpenTable(String nameColumn) {
        for (Row row : Handler.tableDefault) {
            System.out.println(row.getString(nameColumn));
        }
    }

    /**
     * Метод производит поиск по одному значению, всей строки
     *
     * @param value
     */
    //TODO: Кароч поиск сущности по таблице, вывод всей строки или конкретного значения в строке
    public static <T> void tableSearchByValue(T value) throws IOException {

        for (Column column : Handler.tableDefault.getColumns()) {
            column.getName();
            for (Row row : Handler.tableDefault) {
                if (row.values().contains(value)) {
                    System.out.println("ЕСТЬ");
                }

                row.values().stream().forEach(e -> {
                    if (e.equals("Сенатор")) {
                        System.out.println("5");
                    }
                });
            }
        }
        System.out.println("Нет данных по текущему поиску");
    }
}
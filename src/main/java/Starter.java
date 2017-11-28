/**
 * Класс для старта запуска приложения
 * <p>
 * Created by Sharikov Pavel on 31.08.2017.
 */
public class Starter {
    public static void main(String[] args) throws Exception {

        Init.initPropsConfig();
        DataBaseHelper.createNewDataBase();
        DataBaseHelper.openDataBase(Handler.props.getProperty("pathToBase"));

        DataBaseHelper.createTableInDataBase();
        DataBaseHelper.addRowInTable("Сенатор", 4, 406, "DBHandlerCompany");
        DataBaseHelper.getRowInOpenTable();
    }
}
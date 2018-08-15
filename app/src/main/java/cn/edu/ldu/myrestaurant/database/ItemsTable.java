package cn.edu.ldu.myrestaurant.database;
public class ItemsTable {
    public static final String TABLE_NAME="items";
    public static final String COLUMN_ID="itemId";
    public static final String COLUMN_NAME="itemName";
    public static final String COLUMN_CATEGORY="category";
    public static final String COLUMN_PRICE="price";
    public static final String COLUMN_POSITION="sortPosition";
    public static final String COLUMN_DESCRIPTION="description";
    public static final String COLUMN_IMAGE="image";
    public static final String[] ALL_COLUMNS={COLUMN_ID,COLUMN_NAME,COLUMN_CATEGORY,
            COLUMN_POSITION,COLUMN_PRICE,COLUMN_DESCRIPTION,COLUMN_IMAGE};
    public static final String SQL_CREATE_TABLE="CREATE TABLE "+TABLE_NAME
            +"("+
            COLUMN_ID+" TEXT PRIMARY KEY,"
            +COLUMN_NAME+" TEXT,"
            +COLUMN_CATEGORY+" TEXT,"
            +COLUMN_POSITION+" INTEGER,"
            +COLUMN_PRICE+" REAL,"
            +COLUMN_DESCRIPTION+" TEXT,"
            +COLUMN_IMAGE+" TEXT"
            +");";

    public static final String SQL_DELETE_TABLE="DROP TABLE "+TABLE_NAME;
}

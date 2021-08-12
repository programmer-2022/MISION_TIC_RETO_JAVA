package utils;

public class Constants {
    
    //Error messages
    public static final String MSG_SAVE_ERROR = "Error trying to store a record";
    public static final String MSG_UPDATE_ERROR = "Error trying to update a record";
    public static final String MSG_DELETE_ERROR = "Error trying to delete a record";
    public static final String MSG_QUERY_ERROR = "Query error";
        
    //Success messages
    public static final String MSG_SAVE_SUCESS = "The record has been successfully stored";
    public static final String MSG_UPDATE_SUCESS = "The registry has been successfully updated";
    public static final String MSG_DELETE_SUCESS = "The record has been successfully deleted";
        
    //Required fields
    public static final String MSG_REQUIRED = "Fields must not be empty";
    public static final String MSG_NO_EXIST_DATABASE = "The record does not exist in the database";
        
    //Constants jTable Customers
    public static final int ID_CUSTOMER = 0;
    public static final int NAME_CUSTOMER = 1;
    public static final int LASTNAME_CUSTOMER = 2;
    public static final int ADDRESS_CUSTOMER = 3;
    public static final int PHONE_CUSTOMER = 4;
    public static final int EMAIL_CUSTOMER = 5;
    
    //Constants jTable Pets
    public static final int ID_PET = 0;
    public static final int CODE_PET = 1;
    public static final int NAME_PET = 2;
    public static final int AGE_PET = 3;
    public static final int WEIGHT_PET = 4;
    public static final int SPECIE_PET = 5;
    public static final int OWNER_ID_PET = 6;
    public static final int OWNER_FULLNAME_PET = 7;
    
    //Constants jTable Plans
    public static final int ID_PLAN = 0;
    public static final int CODE_PLAN = 1;
    public static final int NAME_PLAN = 2;
    public static final int DESCRIPTION_PLAN = 3;
    public static final int PRICE_PLAN = 4;
    
    //Constants jPanel
    public static final String PANEL_CUSTOMERS = "pnlCustomers";
    public static final String PANEL_PETS = "pnlPets";
    public static final String PANEL_PLANS = "pnlPlans";
    public static final String PANEL_PAYMENTS = "pnlPayments";
    public static final String PANEL_REPORTS = "pnlReports";
    public static final String PANEL_SETTINGS = "pnlSettings";

    //Constants ToolBar
    public static final String TITLE_CUSTOMERS = "CUSTOMERS";
    public static final String TITLE_PETS = "PETS";
    public static final String TITLE_PLANS = "PLANS";
    public static final String TITLE_PAYMENTS = "PAYMENTS";
    public static final String TITLE_REPORTS = "REPORTS";
    public static final String TITLE_SETTINGS = "SETTINGS";
    
    //Icon ToolBar
    public static final String ICON_CUSTOMERS = "team_30px.png";
    public static final String ICON_PETS = "pets_30px.png";
    public static final String ICON_PLANS = "file_30px.png";
    public static final String ICON_PAYMENTS = "pay_30px.png";
    public static final String ICON_REPORTS = "audit_30px.png";
    public static final String ICON_SETTINGS = "wrench_30px.png";
    
    //Constants jComboBox
    public static final String ITEM_SELECT = "-Select-";
    
    //Paths Serializable Object
    public static final String PATH_OUTPUT_SERIALIZABLE = "C:/Users/Alienware/Desktop/PetOrderManagement/output/file.dat";
        
}

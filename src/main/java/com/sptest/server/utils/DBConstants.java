package com.sptest.server.utils;

public class DBConstants {

    public static final String DB_NAME = "phone";
    public static final String JSON_PATH = "shop_data.json";

    //Mongo db info
    public static final String MONGO_COLLECTION_NAME = "money_report";
    public static final String MONGO_DATABASE_NAME = "mongo_test_db";
    public static final String MONGO_LOCAL_HOST = "localhost";
    public static final String MONGO_LOCAL_USER = "";
    public static final String MONGO_LOCAL_PASSWORD = " ";
    public static final int MONGO_LOCAL_PORT = 27017;


    //Role constant
    public static final String ROLE_USER = "role_user";
    public static final String ROLE_ADMIN = "role_admin";
    public static final String ROLE_VIP_USER = "role_vip_user";
    public static final String ROLE_TESTER = "role_tester";

    public class StudentTable {

        public static final String STUDENT_ID = "studentId";
        public static final String STUDENT_NAME = "studentName";
    }

    public class ShopTable {

        public static final String ID = "shopId";
        public static final String NAME = "shopName";
        public static final String ADDRESS = "shopAddress";
        public static final String OWNER = "shopOwner";
        public static final String CUSTOMERS_DENSITY = "shopCustomerDensity";
    }
}

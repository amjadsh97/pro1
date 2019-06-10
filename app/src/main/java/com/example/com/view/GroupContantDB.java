package com.example.com.view;

import android.provider.BaseColumns;

public class GroupContantDB  {

    public GroupContantDB() {
    }

    public static final class GroupEntry implements BaseColumns {
       public static final String TABLE_NAME = "GroupList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }

}

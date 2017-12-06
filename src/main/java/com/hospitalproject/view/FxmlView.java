package com.hospitalproject.view;

import java.util.ResourceBundle;

/**
 * Created by kingm on 26.11.2017.
 */
public enum FxmlView {

    MAIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("main.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/main.fxml";
        }
    },
    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/login.fxml";
        }
    },
    DOCTORS{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("doctors.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/doctors.fxml";
        }
    },
    PATIENTSINFO{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("patientsInfo.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/patientInf.fxml";
        }
    };

    public abstract String getTitle();
    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}

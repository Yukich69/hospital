package com.solvd.hospital;


import com.solvd.hospital.info.InfoSetup;

import java.io.File;


public class Main {

        public static void main(String[] args) {
            InfoSetup is = new InfoSetup();
            is.info(new File("HOSP_INFO.txt"));
            is.start();
        }

}

package com.labSync.LabSync;

import com.labSync.LabSync.persistence.DAOS.UserDAO;
import com.labSync.LabSync.persistence.MySqlConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabSyncApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LabSyncApplication.class, args);

        MySqlConnection ms = new MySqlConnection();


	}
}

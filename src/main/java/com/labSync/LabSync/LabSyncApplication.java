package com.labSync.LabSync;

import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOS.UserDAO;
import com.labSync.LabSync.persistence.MySqlConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabSyncApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LabSyncApplication.class, args);

        MySqlConnection ms = new MySqlConnection();

        UserDAO d = new UserDAO(ms);

        User u = new User("Isadora2845", "Isa", "isa@gmail.com", "isa@MIT.com", "2845", true, null);
        d.delete(3);
	}
}

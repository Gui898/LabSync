package com.labSync.LabSync;

import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOS.ProjectDAO;
import com.labSync.LabSync.persistence.DAOS.UserDAO;
import com.labSync.LabSync.persistence.MySqlConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabSyncApplication.class, args);
        User user = new User("Guilherme", "Gui", "gui@gmail.com", "gui@MIT.com", "123", true, "Sou foda");
        Project project = new Project("É US GURI DO METANOL", "Ciencia", "Instrumentos usados", "Texto del proyecto", "Conclusión del proyecto", "Tecnologías usadas");

        ProjectDAO projectDAO = new ProjectDAO(new MySqlConnection());
        UserDAO userDAO = new UserDAO(new MySqlConnection());

	}
}

package com.labSync.LabSync;

import com.labSync.LabSync.models.Posts;
import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOS.PostsDAO;
import com.labSync.LabSync.persistence.DAOS.ProjectDAO;
import com.labSync.LabSync.persistence.DAOS.UserDAO;
import com.labSync.LabSync.persistence.MySqlConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabSyncApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LabSyncApplication.class, args);

        MySqlConnection ms = new MySqlConnection();

        ProjectDAO projectDAO = new ProjectDAO(ms);
        UserDAO userDAO = new UserDAO(ms);
        PostsDAO postDAO = new PostsDAO(ms);

        User user = new User("Guilherme", "Gui", "gui@gmail.com", "gui@MIT.com", "123", true, "Sou foda");
        Project project = new Project("É US GURI DO METANOL", "Ciencia", "Instrumentos usados", "Texto del proyecto", "Tecnologías usadas", user);
        Posts post = new Posts(0, project);

        System.out.println(postDAO.findAll());;
	}
}

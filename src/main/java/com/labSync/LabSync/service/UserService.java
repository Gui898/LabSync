package com.labSync.LabSync.service;

import com.labSync.LabSync.exception.UserConflictException;
import com.labSync.LabSync.exception.UserInvalidValuesException;
import com.labSync.LabSync.exception.UserNotFoundException;
import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOS.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    UserDAO userDAO;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User addUser(User user) {
        validateUser(user);
        checkDuplicateEmails(user);
        userDAO.add(user);
        return user;
    }

    public User updateUser(User user) {
        validateUser(user);
        userDAO.edit(user);
        return user;
    }

    public long delete(long id){
        userDAO.delete(id);
        return id;
    }

    public User getUserById(int id) {
        if(userDAO.findById(id) == null){
            throw new UserNotFoundException();
        }
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        if(userDAO.findAll().isEmpty()){
            throw new UserNotFoundException("Usuários não encontrados");
        }
        return userDAO.findAll();
    }

    private void validateUser(User user) {
        if (user == null || user.getEmail() == null) {
            throw new UserInvalidValuesException("O email ou o usuário não podem ser nulos");
        }

        if (!EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            throw new UserInvalidValuesException("Email inválido");
        }

        if (user.getReaderOrAuthor() &&
                (user.getAcademicEmail() == null ||
                        !EMAIL_PATTERN.matcher(user.getAcademicEmail()).matches())) {
            throw new UserInvalidValuesException("Email acadêmico inválido");
        }
    }

    private void checkDuplicateEmails(User user) {
        if (userDAO.findByEmail(user.getEmail()) != null ||
                (user.getAcademicEmail() != null &&
                        userDAO.findByEmail(user.getAcademicEmail()) != null)) {
            throw new UserConflictException();
        }
    }

}

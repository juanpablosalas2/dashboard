package com.projects.dashboard.services;

import com.projects.dashboard.models.Users;
import com.projects.dashboard.repository.UsersRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final EntityManager entityManager;
    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void deleteUsers(Long id) {
         usersRepository.deleteById(id);
    }

    @Override
    public void registerUsers(Users users) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, users.getPass());
        users.setPass(hash);
        usersRepository.save(users);
    }

    @Override
    public boolean verifyCredentials(Users users) {
        String query = "FROM Users WHERE email = :email";
        List<Users> resultList = entityManager.createQuery(query).setParameter("email", users.getEmail()).getResultList();

        if (resultList.isEmpty()){
            return false;
        }
        String password = resultList.get(0).getPass();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);


        return argon2.verify(password,users.getPass());
    }

}

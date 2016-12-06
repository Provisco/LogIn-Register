package loginAndRegister.Model;

import loginAndRegister.Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 15/11/16.
 */
public class MockUserService implements UserService {

    private List<User> userList = new ArrayList();
    //private User user;

    @Override
    public boolean authenticate(String username, String password) {
        //posso mudar isto e fazer um metodo compare na classe User que compara as propriedades dos dois users (name e pw)
        User tempUser = findByName(username);
        if (tempUser == null) {
            System.out.println("User not found");
            return false;
        }
        if (tempUser.getPassword().equals(password)) {
            System.out.println("Login Successful");
            return true;
        }
        System.out.println("Wrong password");
        return false;
    }


    @Override
    public boolean addUser(User user) {
        if (findByName(user.getUsername()) != null) {
            System.out.println("That user name is already taken");
            return false;
        }
        userList.add(user);
        System.out.println("User added successfully");
        return true;

    }

    @Override
    public int count() {
        return userList.size();
    }

    @Override
    public User findByName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return userList.get(i);
            }
        }
        System.out.println("That user does not exist");
        return null;

    }
}

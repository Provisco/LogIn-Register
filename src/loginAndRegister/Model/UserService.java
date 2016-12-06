package loginAndRegister.Model;

import loginAndRegister.Model.User;

/**
 * Created by codecadet on 15/11/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);
        //while in isLoggedInMode will iterate over the container list and if it finds a match will "login" user


    boolean addUser(User user);
        //while in isRegisteredMode will addUser() if findByName() returns false.


    int count();
        //counts how many users have registered
        //returns size of container

    User findByName(String username);


    //iterates the container list and returns user if a match is found
}

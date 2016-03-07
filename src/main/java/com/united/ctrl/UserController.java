package com.united.ctrl;


import com.united.auth.User;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.users.AddUserBB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 @author Linn
 */
@Named("userController")
@RequestScoped
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());
    private School school;
    
    private AddUserBB addBB;
//    private EditUserBB editBB;
//    private DeleteUserBB delBB;
    
   
    public void newUser() {
        LOG.log(Level.INFO, "Backin bean " + addBB);
        User p = new User(addBB.getId(), addBB.getPasswd(), addBB.getGroups());
        System.out.println("School:" + school + "| Userlist: "+ school.getUserList());
        school.getUserList().create(p);
        //List<User> ps = school.getUserList().getByName(addBB.getName());      
        //LOG.log(Level.INFO, "New value " + ps.get(0));
    }

    public void updateUser() {
//       User p = new User(editBB.getId(), editBB.getName(), Double.valueOf(editBB.getPrice()));
//       school.getUserList().update(p);    
    }

    public void deleteUser() {
//       String id = delBB.getId();
//       school.getUserList().delete(id);
    }

    @Inject
    public void setAddBB(AddUserBB addBB) {
        this.addBB = addBB;
    }
//    
//    @Inject
//    public void setEditBB(EditUserBB editBB) {
//        this.editBB = editBB;
//    }
//    
//    @Inject
//    public void setDelBB(DeleteUserBB delBB) {
//        this.delBB = delBB;
//    }

    @Inject
    public void setSchool(SingletonSchool ss) {
        this.school = ss.getSchool();
    }

}

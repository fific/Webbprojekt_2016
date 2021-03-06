package com.united.ctrl;



import com.united.core.Course;
import com.united.core.Moment;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.moments.AddMomentBB;
import com.united.view.moments.DeleteMomentBB;
import com.united.view.moments.EditMomentBB;
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
@Named("momentController")
@RequestScoped
public class MomentController {

    private static final Logger LOG = Logger.getLogger(MomentController.class.getSimpleName());

    @Inject
    private School school;
    
    private AddMomentBB addBB;
    private EditMomentBB editBB;
    private DeleteMomentBB delBB;
    
   
    public void newMoment(String courseId) {     
        Moment p = new Moment(addBB.getName());
        Course c = school.getCourseList().getById(courseId);
        c.addToMoments(p);
        c.addVersion();
        school.getCourseList().update(c);
    }

    public void updateMoment() {
        Long momentID = Long.parseLong(editBB.getId());
       
        Moment m = school.getMomentList().getById(momentID);
        m.setName(editBB.getName());
        Course c = m.getCourse();
        c.addVersion();
        
        school.getMomentList().update(m);    
        school.getCourseList().update(c); 
    }

    public void deleteMoment(String courseId) {
        Long id = Long.parseLong(delBB.getId());

        Moment m = school.getMomentList().getById(id);
        Course c = school.getCourseList().getById(courseId);
        c.removeMoment(m);
        c.addVersion();
        school.getCourseList().update(c);    
    }

    @Inject
    public void setAddBB(AddMomentBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setEditBB(EditMomentBB editBB) {
        this.editBB = editBB;
    }
    
    @Inject
    public void setDelBB(DeleteMomentBB delBB) {
        this.delBB = delBB;
    }


}

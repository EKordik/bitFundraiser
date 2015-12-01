package edu.wctc.web.ek.bitfundraiser.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import edu.wctc.web.ek.bitfundraiser.entity.Linkedin;
import edu.wctc.web.ek.bitfundraiser.repository.LinkedInRepository;

/**
 *
 * @author emmakordik
 */
@Repository("lService")
@Transactional(readOnly=true)
public class LinkedInService {

    @Autowired
    private LinkedInRepository linkedRepo;
    
   
    public LinkedInService(){
        
    }
    
    public List<Linkedin> findAll(){
        return linkedRepo.findAll();
    }
    
    public Linkedin findById(String id){
        return linkedRepo.findOne(new Integer(id));
    }
    
   
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void remove(Linkedin person){
        linkedRepo.delete(person);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Linkedin edit(Linkedin person){
        System.out.println("Saving: " + person);
        return linkedRepo.saveAndFlush(person);
    }
}

package edu.wctc.web.ek.bitfundraiser.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import edu.wctc.web.ek.bitfundraiser.entity.Linkedin;

/**
 *
 * @author emmakordik
 */
public interface LinkedInRepository extends JpaRepository<Linkedin, Integer>, Serializable {
    
   
}


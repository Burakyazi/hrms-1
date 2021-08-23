package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.entities.cvs.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image,Integer> {

    Image getByCandidate_Id(int id);

}

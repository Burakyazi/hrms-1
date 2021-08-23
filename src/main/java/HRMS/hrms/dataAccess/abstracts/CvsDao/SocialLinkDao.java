package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.entities.cvs.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialLinkDao extends JpaRepository<SocialLinkDao,Integer> {

    boolean existsByUrl(String url);

    List<SocialLink> getByCandidate_Id(int id);
}

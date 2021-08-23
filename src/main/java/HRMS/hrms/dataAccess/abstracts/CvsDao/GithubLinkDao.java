package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.entities.cvs.GithubLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubLinkDao extends JpaRepository<GithubLink,Integer> {

    boolean existsByUrl(String url);

    GithubLink getByCandidate_Id(int id);
}

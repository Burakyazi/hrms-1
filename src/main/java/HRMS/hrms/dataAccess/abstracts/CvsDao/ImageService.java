package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    DataResult<List<Image>> getAll();
    DataResult<Image> getById(int id);
    DataResult<Image> getByUserId(int id);

    Result add(MultipartFile multipartFile , int id);
    Result delete(int id) throws IOException;
}

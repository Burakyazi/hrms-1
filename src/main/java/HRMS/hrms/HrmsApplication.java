package HRMS.hrms;

import HRMS.hrms.adapters.cloudinary.Cloudinary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;

@SpringBootApplication
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dnsfzrpye",
				"api_key", "729281238438624",
				"api_secret", "aIn6kCNHgcaPjUNtQf8OLDVdgoQ"));

	}
	}

}

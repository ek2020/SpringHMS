package global.coda.hms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("global.coda.hms.mapper")
public class SpringHmsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringHmsApplication.class, args);
	}

}

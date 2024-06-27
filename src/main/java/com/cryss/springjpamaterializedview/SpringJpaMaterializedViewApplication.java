package com.cryss.springjpamaterializedview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaMaterializedViewApplication {

//	@Autowired
//	private CategoryInsertRepository categoryInsertRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaMaterializedViewApplication.class, args);

	}

//	@PostConstruct
//	public void initializeDB(){
//
//
//
//		Category category = Category.
//				builder ()
//				.id (1L)
//				.name ("catA")
//				.parentCategory (null)
//				.build ();
//
//		Category category2 = Category.
//				builder ()
//				.id (3L)
//				.name ("catB")
//				.parentCategory (category)
//				.build ();
//
//
////
//		Category category3 = Category.
//				builder ()
//				.id (4L)
//				.name ("catC")
//				.parentCategory (category2)
//				.build ();
//
//
//		//categoryInsertRepository.insertWithQuery (category2);
//		categoryInsertRepository.insertWithQuery (category3);
//	}



}

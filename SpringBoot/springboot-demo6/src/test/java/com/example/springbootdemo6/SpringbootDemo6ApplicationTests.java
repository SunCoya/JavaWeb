package com.example.springbootdemo6;
import com.example.springbootdemo5.HeaderGenerator;
import com.example.springbootdemo5.HeaderParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemo6ApplicationTests {
	@Autowired
	HeaderParser headerParser;
	@Autowired
	HeaderGenerator headerGenerator;
	@Test
	void getBean(){
		headerParser.parse();
		headerGenerator.generate();
	}

}

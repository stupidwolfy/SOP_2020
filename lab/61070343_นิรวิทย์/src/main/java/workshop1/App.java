package workshop1;

import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@RestController
@EnableAutoConfiguration

public class App {
	List<Car>allcar = new ArrayList<Car>();
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String hello(@RequestBody Object object) {
		return String.format("{\"payload\":\"%s\"}", object);
	}

	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<List<Car>> create(@RequestBody List<Car> cars) {
		cars.stream().forEach(c -> allcar.add(c));
	
		return new ResponseEntity<List<Car>>(allcar, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/car/{num}", method = RequestMethod.PATCH)
	
	public ResponseEntity<List<Car>> patch(@RequestBody Car car,@PathVariable("num") int num) {
		allcar.set(num-1,car);
		return new ResponseEntity<List<Car>>(allcar, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/car/{num}", method = RequestMethod.GET)
	
	public ResponseEntity<Car> get(@PathVariable("num") int num) {

		Car car = allcar.get(num-1);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/car/{num}", method = RequestMethod.DELETE)
	
	public ResponseEntity<List<Car>> delete(@PathVariable("num") int num) {

		allcar.remove(num-1);
		
		return new ResponseEntity<List<Car>>(allcar, HttpStatus.OK);
	}


}

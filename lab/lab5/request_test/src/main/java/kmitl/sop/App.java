package kmitl.sop;

import java.util.ArrayList;
import java.util.List;

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

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {
	List<Car> car_pool = new ArrayList<Car>();

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<List<Car>> post(@RequestBody List<Car> cars) {
		cars.stream().forEach(car -> car_pool.add(car));

		return new ResponseEntity<List<Car>>(car_pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/car/{index}", method = RequestMethod.PATCH)
	public ResponseEntity<List<Car>> patch(@RequestBody Car car, @PathVariable("index") int index) {
		// car_pool.set({index}, cars.get(0));
		car_pool.set(index - 1, car);

		return new ResponseEntity<List<Car>>(car_pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/car/{index}", method = RequestMethod.GET)
	public ResponseEntity<Car> get(@PathVariable("index") int index) {
		Car car = car_pool.get(index - 1);

		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	@RequestMapping(value = "/car/{index}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Car>> delete(@PathVariable("index") int index) {
		car_pool.remove(index - 1);

		return new ResponseEntity<List<Car>>(car_pool, HttpStatus.OK);
	}

	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> get_all() {

		return new ResponseEntity<List<Car>>(car_pool, HttpStatus.OK);
	}

}

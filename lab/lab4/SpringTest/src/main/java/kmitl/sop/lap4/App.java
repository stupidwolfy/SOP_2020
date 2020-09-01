package kmitl.sop.lap4;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String hello(@RequestBody Object object) {
		return String.format("{\"payload\":\"%s\"}", object);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Car> get() {
		Car car = new Car();
		car.setColor("Blue");
		car.setType("Truck");
		car.setDisplacement(1500);
		car.hasSunroof(false);
		car.setSpeed(60);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Car> update(@RequestBody Car car) {
		String color = car.getColor();
		String type = car.getType();
		int displacement = car.getDisplacement();
		boolean hasSubroof = car.hasSunroof();

		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateMany", method = RequestMethod.POST)
	public ResponseEntity<List<Car>> updateMany(@RequestBody List<Car> cars){
		cars.stream().forEach(c -> c.setSpeed(c.getSpeed()+ 10));
		
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
}

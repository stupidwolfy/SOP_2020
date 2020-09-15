package kmitl.sop.homework;

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
	
	public List<Car>car_list= new ArrayList<Car>();
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<List<Car>> addcars(@RequestBody List<Car> cars){
		cars.stream().forEach(c -> car_list.add(c));
		
		return new ResponseEntity<List<Car>>(car_list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/car/{index}", method = RequestMethod.PATCH)
	public ResponseEntity<List<Car>> patch(@RequestBody List<Car> cars, @PathVariable ("index") int index){
		cars.stream().forEach(car -> car_list.set(index-1, car));
		
		return new ResponseEntity<List<Car>>(car_list , HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/car/{index}", method = RequestMethod.GET)
	public ResponseEntity<Car> get(@PathVariable ("index") int index){
		Car car = car_list.get(index-1);
		
		return new ResponseEntity<Car>(car , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/car/{index}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Car>> delete(@PathVariable ("index") int index){
		car_list.remove(index-1);
		
		return new ResponseEntity<List<Car>>(car_list , HttpStatus.OK);
	}
}
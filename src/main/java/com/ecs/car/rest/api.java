package com.ecs.car.rest;

import com.ecs.car.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class api {
    @Autowired
    CarRepository carRepository;
    /*@PostMapping(path = "/car")
    public ResponseEntity<ApiResponse> addCar(@Valid@RequestBody Car car) throws JsonProcessingException {
        ApiResponse response=new ApiResponse();
        try {
            Car result = carRepository.save(car);
            response.setMessage("SAVED");
            response.setCar(result);
        }catch (org.springframework.dao.DataIntegrityViolationException e)
        {
            response.setMessage("Car with same make, model and year exist. its a duplicate car");
        }
        return ResponseEntity.ok(response);
    }
   @PutMapping(path = "/car")
    public ResponseEntity<ApiResponse> updateCar(@RequestBody UpdateCarRequest car) throws JsonProcessingException {
       ApiResponse response=new ApiResponse();
        Optional.ofNullable(car.getId()).ifPresentOrElse(aLong -> {
            Optional<Car> result=carRepository.findById(car.getId());
            result.ifPresentOrElse(resultCar -> {
                Optional.ofNullable(car.getMake()).ifPresent(s -> resultCar.setMake(car.getMake()));
                Optional.ofNullable(car.getModel()).ifPresent(s -> resultCar.setModel(car.getModel()));
                Optional.ofNullable(car.getYear()).ifPresent(s ->
                {
                    if (StringUtils.isNumeric(car.getYear()))
                        resultCar.setYear(car.getYear());
                });
                try
                {
                    carRepository.save(resultCar);
                    response.setCar(resultCar);
                    response.setMessage("Updated");

                }catch (org.springframework.dao.DataIntegrityViolationException e)
                {
                    response.setCar(resultCar);
                    response.setMessage("Car with same make, model and year exist. its a duplicate car");
                }

            }
            ,() -> {response.setMessage("No car was found with id: "+car.getId());});
        },() -> {response.setMessage("No id was passed");});
        if(response.getMessage().equalsIgnoreCase("updated"))
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }*/

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
    }
}

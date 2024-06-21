package br.com.iago.restap.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.restap.excptions.UnsuportedMathOperationException;
import br.com.iago.restap.math.SimpleMath;
import br.com.iago.restap.resquestconverter.NumberConverter;

@RestController
public class MathController {
private SimpleMath math = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));		
	}	
	
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.subtraction(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));	
	}	
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.multiplication(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));	
	}	
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.division(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));	
	}

	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.mean(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));		
	}	
	
	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if (!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.squareRoot(NumberConverter.covertToDouble(number));		
	}	
}

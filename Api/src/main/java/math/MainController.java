package math;


import java.net.BindException;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import math.modal.Data;
import math.modal.DataAccessories;

@RestController
public class MainController{
	private static Logger logger = LogManager.getLogger(MainController.class);
	
	@RequestMapping("/min")
	public String min(@Valid Data input,BindingResult error) { 
			if(error.hasErrors()) {
				logger.error("API call with list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Input parameters bad!");
				}
			DataAccessories format = new DataAccessories();
			Double []list = format.convertToList(input.getList());
			double q = format.convertToQ(input.getQ());
			if( q > list.length) {
				logger.error("Check your quantifier"
						+ "list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," Check your quantifier");
			}
			try {
				if(q==0)
					return "MinList: ";
				StringBuffer result = new StringBuffer();
				Arrays.sort(list,(a,b)->{return a.compareTo(b);});
				for(int i=0;i<q;i++) {
					result.append(list[i]);
					result.append(" , ");
				}
				result.setLength(result.length()-3);
				return "MinList: " + result.toString();
			}catch(Exception ex) {
				logger.error("error in processing min");
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR," min api not working");
				}
			}
	
	@RequestMapping("/max")
	public String max(@Valid Data input,BindingResult error) { 
			if(error.hasErrors()) {
				logger.error("API call with list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Input parameters bad!");
				}
			DataAccessories format = new DataAccessories();
			Double []list = format.convertToList(input.getList());

			double q = format.convertToQ(input.getQ());
			if( q > list.length) {
				logger.error("Check your quantifier"
						+ "list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," Check your quantifier");
			}
			try {
				if(q==0)
					return "MaxList: ";
				StringBuffer result = new StringBuffer();
				Arrays.sort(list,(a,b)->{return b.compareTo(a);});
				for(int i=0;i<q;i++) {
					result.append(list[i]);
					result.append(" , ");
				}
				result.setLength(result.length()-3);
				return "MaxList: " + result.toString();
			}catch(Exception ex) {
				logger.error("error in processing max");
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR," max api not working");
			}
	}
	
	@RequestMapping("/avg")
	public String avg(@Valid Data input,BindingResult error) { 
			if(error.hasErrors()) {
				logger.error("API call with list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," Input parameters bad!");
				}
			DataAccessories format = new DataAccessories();
			Double []list = format.convertToList(input.getList());
			double q = format.convertToQ(input.getQ());
			if( q!=Integer.MAX_VALUE) {
				logger.error("Check your quantifier"
						+ "list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," No Quantifier for avg api");
			}
			try {
				Double mean = 0.0;
				for(int i=0;i<list.length;i++) {
					mean = mean + list[i];
				}
				mean /=list.length; 
				return "AvgList: " + String.format("%.3s", mean);
			}catch(Exception ex) {
				logger.error("error in processing avg");
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR," error in avg api");
			}
	}
	
	@RequestMapping("/median")
	public String median(@Valid Data input,BindingResult error) { 
			if(error.hasErrors()) {
				logger.error("API call with list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," Input parameters bad!");
				}
			DataAccessories format = new DataAccessories();
			Double []list = format.convertToList(input.getList());
			double q = format.convertToQ(input.getQ());
			if( q!= Integer.MAX_VALUE) {
				logger.error("Check your quantifier"
						+ "list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," No Quantifier for median api");
			}
			try {
				Arrays.sort(list,(a,b)->{return a.compareTo(b);});
				if(list.length % 2 == 0) {
						return "median:  " + ((list[list.length/2] + list[(list.length/2)-1])/2.0);
				}
				else
					return "median: " + list[list.length/2];  
			}catch(Exception ex) {
				logger.error("error in processing median");
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR," error in median api");
			}
	}
	
	
	@RequestMapping("/percentile")
	public String percentile(@Valid Data input,BindingResult error) { 
			if(error.hasErrors()) {
				logger.error("API call with list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," Input parameters bad!");
				}
			DataAccessories format = new DataAccessories();
			Double []list = format.convertToList(input.getList());
			double q = format.convertToQ(input.getQ());
			if(q > 100) {
				logger.error("Check your quantifier"
						+ "list: " + input.getList() +" and q:" + input.getQ());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST," Check your quatifier");
			}
			try {
				Arrays.sort(list);
				double pointer = (q / 100) * (list.length + 1);
				if(pointer<=1)
					return "Percentile: "+ list[0];
				else if(pointer >= list.length)
					return "Percentile: " + list[list.length -1];
				else
					if(pointer%1>0)
						return "Percentile: " + (list[(int) pointer -1] + ((list[(int) pointer] -
								list[(int) pointer -1]) /2));
					else
						return "Percentile: " + list[(int) pointer -1];
				
			}catch(Exception ex) {
				logger.error("error in processing Percentile");
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR," error in percentile api");
			}
	}

	
}
package com.digitalbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.dto.Order;
import com.digitalbooks.payload.response.JwtResponse;
import com.digitalbooks.services.impl.PaypalServiceImpl;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
//@RequestMapping("/api/v1/payment")
@CrossOrigin(origins="*", maxAge=3600)
public class PaypalController {

	@Autowired
	PaypalServiceImpl service;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/")
	public String home() {
		return null;
	}

	@PostMapping("/pay")
	@ResponseBody
	public ResponseEntity<String> payment(@RequestBody  Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8085/" + CANCEL_URL,
					"http://localhost:8085/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					//String linkURL = "redirect:"+link.getHref();
//					return "redirect:"+link.getHref();
					//return ResponseEntity.ok("redirect:"+link.getHref());
					return ResponseEntity.ok().body(link.getHref());
				}
			}
			
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
//		return "redirect:/";
		return ResponseEntity.ok("redirect:/");
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	                return "success";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }

}

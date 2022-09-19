package com.digitalbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.dto.Order;
import com.digitalbooks.entities.Userpurchased;
import com.digitalbooks.services.BookService;
import com.digitalbooks.services.impl.PaypalServiceImpl;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
//@RequestMapping("/api/v1/payment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PaypalController {

	@Autowired
	PaypalServiceImpl service;

	@Autowired
	BookService bookService;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	public Integer bookId;
	public Integer userId;

	private void PaypalController(Integer bId, Integer uId) {
		this.bookId = bId;
		this.userId = uId;

	}

	@GetMapping("/")
	public String home() {
		return null;
	}

	@PostMapping("/pay")
	@ResponseBody
	public ResponseEntity<String> payment(@RequestBody Order order) {

		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:4200/books/?" + CANCEL_URL,
					"http://localhost:4200/books/?" + SUCCESS_URL);
			for (Links link : payment.getLinks()) {
				if (link.getRel().equals("approval_url")) {
					// String linkURL = "redirect:"+link.getHref();
					Integer bId = order.getBookId();
					Integer uId = order.getUserId();
					PaypalController(bId, uId);
					return ResponseEntity.ok().body(link.getHref());
				}
			}

		} catch (PayPalRESTException e) {

			e.printStackTrace();
		}
		return ResponseEntity.ok(home());
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
				purchOrderData(bookId, userId);
				return "success";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		return home();
	}

	public ResponseEntity<Userpurchased> purchOrderData(Integer bookId, Integer UserId) {
		Userpurchased purchased = this.bookService.purchOrderDataSave(bookId, UserId);
		return new ResponseEntity<>(purchased, HttpStatus.CREATED);
	}

}

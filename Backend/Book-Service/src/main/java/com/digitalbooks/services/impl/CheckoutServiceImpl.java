//package com.digitalbooks.services.impl;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.UUID;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.digitalbooks.dto.PaymentInfo;
//import com.digitalbooks.dto.Purchase;
//import com.digitalbooks.dto.PurchaseResponse;
//import com.digitalbooks.entities.Order;
//import com.digitalbooks.entities.OrderItem;
//import com.digitalbooks.entities.User;
//import com.digitalbooks.repository.UserRepository;
//import com.digitalbooks.services.CheckoutService;
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//
//@Service
//public class CheckoutServiceImpl implements CheckoutService {
//
//	 private UserRepository userRepository;
//
//	    public CheckoutServiceImpl(UserRepository userRepository,
//	                               @Value("${stripe.key.secret}") String secretKey) {
//
//	        this.userRepository = userRepository;
//
//	        // initialize Stripe API with secret key
//	        Stripe.apiKey = secretKey;
//	    }
//
//	    @Override
//	    @Transactional
//	public PurchaseResponse placeOrder(Purchase purchase) {
//	    	// retrieve the order info from dto
//	        Order order = purchase.getOrder();
//
//	        // generate tracking number
//	        String orderTrackingNumber = generateOrderTrackingNumber();
//	        order.setOrderTrackingNumber(orderTrackingNumber);
//
//	        // populate order with orderItems
//	        Set<OrderItem> orderItems = purchase.getOrderItems();
//	        orderItems.forEach(item -> order.add(item));
//
//	        // populate order with billingAddress and shippingAddress
//	        order.setBillingAddress(purchase.getBillingAddress());
//	        order.setShippingAddress(purchase.getShippingAddress());
//
//	        // populate customer with order
//	        User user = purchase.getUser();
//
//	        // check if this is an existing user
//	        String theEmail = user.getEmail();
//
//	        User userFromDB = userRepository.findByEmail(theEmail);
//
//	        if (userFromDB != null) {
//	            // we found them ... let's assign them accordingly
//	            user = userFromDB;
//	        }
//
//	        user.add(order);
//
//	        // save to the database
//	        userRepository.save(user);
//
//	        // return a response
//	        return new PurchaseResponse(orderTrackingNumber);
//	}
//
//	@Override
//	public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {
//		 List<String> paymentMethodTypes = new ArrayList<>();
//	        paymentMethodTypes.add("card");
//
//	        Map<String, Object> params = new HashMap<>();
//	        params.put("amount", paymentInfo.getAmount());
//	        params.put("currency", paymentInfo.getCurrency());
//	        params.put("payment_method_types", paymentMethodTypes);
//
//	        return PaymentIntent.create(params);
//	}
//	
//    private String generateOrderTrackingNumber() {
//
//        // generate a random UUID number (UUID version-4)
//        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
//        //
//        return UUID.randomUUID().toString();
//    }
//
//   
//}
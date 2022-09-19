//package com.digitalbooks.services;
//
//import com.digitalbooks.dto.PaymentInfo;
//import com.digitalbooks.dto.Purchase;
//import com.digitalbooks.dto.PurchaseResponse;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//
//public interface CheckoutService {
//
//    PurchaseResponse placeOrder(Purchase purchase);
//
//    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
//
//}
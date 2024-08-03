package com.example.payment_service.config;


//Configure Stripe or other payment gateway SDKs in this class.
@Configuration
public class PaymentConfig {
    @Value("${payment.gateways.stripe.apiKey}")
    private String stripeApiKey;

    @Bean
    public void configureStripe() {
        Stripe.apiKey = stripeApiKey;
    }

    // Add configuration for other payment gateways as needed
}

package com.example.bff_service.interceptor;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitInterceptor implements HandlerInterceptor {

    private final ConcurrentHashMap<String, RateLimitInfo> requestCounts = new ConcurrentHashMap<>();
    private final int MAX_REQUESTS_PER_MINUTE = 60; // Set the rate limit here

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String clientIp = getClientIp(request);

        RateLimitInfo rateLimitInfo = requestCounts.computeIfAbsent(clientIp, k -> new RateLimitInfo());

        long currentTime = System.currentTimeMillis();
        long timeSinceLastReset = currentTime - rateLimitInfo.timestamp;

        // Reset the count if more than a minute has passed
        if (timeSinceLastReset > TimeUnit.MINUTES.toMillis(1)) {
            rateLimitInfo.timestamp = currentTime;
            rateLimitInfo.requestCount.set(1);
        } else {
            // Check if the request count exceeds the limit
            if (rateLimitInfo.requestCount.incrementAndGet() > MAX_REQUESTS_PER_MINUTE) {
                response.setStatus(429); // 429 status code
                response.getWriter().write("Rate limit exceeded. Try again later.");
                return false;
            }
        }

        return true;
    }

    private String getClientIp(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }

    private static class RateLimitInfo {
        private final AtomicInteger requestCount = new AtomicInteger(0);
        private long timestamp = System.currentTimeMillis();
    }

}

/*ConcurrentHashMap<String, RateLimitInfo>:

Used to store the request count and timestamp for each client IP address.
MAX_REQUESTS_PER_MINUTE:

Defines the maximum number of allowed requests per minute for each client. Adjust this value as needed.
preHandle Method:

Rate Limit Check: The preHandle method checks if the client has exceeded the allowed number of requests per minute. If they have, it returns an HTTP 429 status (Too Many Requests) and prevents further processing.
Rate Limit Reset: If more than a minute has passed since the last reset, the count is reset.
getClientIp Method:

Retrieves the client's IP address from the request, accounting for possible proxy forwarding with the X-Forwarded-For header.
RateLimitInfo Class:

A helper class that stores the request count (AtomicInteger) and the timestamp of the last request.*/

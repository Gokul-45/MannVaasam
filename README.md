# MANNVAASAM

Professional agriculture-focused multi-vendor marketplace foundation.

## Stack
React + Vite + React Router; Java 21 + Spring Boot + Spring Security + JWT + JPA; MySQL; FastAPI AI service.

## Core differentiator
Delivery uses seller coordinates, seller delivery radius and buyer coordinates. The backend Haversine calculation is the source of truth.

## Local setup
Copy `.env.example` to `.env`, set strong local values, and set `DEMO_SELLER_PASSWORD` without committing it. Run `docker compose up --build`, or run the services separately.

Demo seller email: `demo.seller@mannvaasam.local`; password comes only from the local `DEMO_SELLER_PASSWORD` environment variable.

## Current implementation status
Implemented: responsive marketplace UI, catalog/category APIs, BCrypt registration/login, JWT authentication filter, delivery-distance service/API, secure environment templates, demo seller/product seed, FastAPI fallback, Docker, CI and Google Cloud documentation.

Remaining before claiming full production readiness: persisted cart/checkout/order/payment/review/wishlist modules, complete seller/admin CRUD and ownership policies, geocoding, A4 printable order document, production database migrations, media storage and end-to-end integration tests.

See `docs/` for architecture, API, database, security, payment and Google Cloud guidance.
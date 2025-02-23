
# Webcrawler System

  1. High-Level Design (HLD)
1.1 Functional Requirements
Fetch web pages from the internet.
Follow hyperlinks to discover new pages.
Store extracted data for indexing and analysis.
Allow configuration for domain-specific crawling.
Support distributed crawling.
1.2 Non-Functional Requirements
Scalability: The system should scale horizontally to crawl millions/billions of web pages.
Efficiency: Minimize redundant requests, respect rate limits, and avoid overloading servers.
Politeness: Follow robots.txt, user-agent rules, and avoid DoS-like behavior.
Fault Tolerance: Handle failures in DNS resolution, timeouts, and broken links.
Near Real-Time Updates: Support frequent crawling for frequently updated websites.
2. System Components
2.1 Architecture Overview
A distributed web crawler consists of the following components:

URL Frontier (Queue Manager)

Stores URLs to be crawled.
Prioritizes URLs (e.g., by freshness, importance, or domain rules).
Manages duplicate avoidance.
Fetcher (HTTP Downloader)

Retrieves web pages using HTTP requests.
Handles rate limiting and retries.
Parser (HTML Processor)

Extracts links (URLs) from fetched pages.
Extracts metadata and structured content.
URL Filter & Deduplication

Ensures URLs are unique.
Applies filtering rules (e.g., avoid irrelevant links).
Data Storage

Document Storage (HTML pages, metadata).
Index Storage (for full-text search).
Graph Storage (for link relationships, PageRank computation).
Scheduler

Decides which URLs to fetch next.
Balances load across domains.
Respects robots.txt policies.
Distributed Coordination

Uses Kafka, Redis, or Zookeeper for coordination.
Ensures multiple crawlers don't crawl the same URL redundantly.
Monitor & Analytics

Logs crawling status, response codes, and failures.
Detects traps (e.g., infinite loops, duplicate pages).


Design decisions

Avoid duplicate url fetches
Persistent Deduplication using Redis or a Database

Avoid duplicate contents

Exact Deduplication using Content Hashing
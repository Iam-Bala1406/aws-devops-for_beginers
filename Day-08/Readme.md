Amazon S3 (Simple Storage Service) - Complete Details
What is Amazon S3?
Amazon Simple Storage Service (Amazon S3) is an object storage service that provides high scalability, security, performance, and data availability. It allows users to store and retrieve any amount of data at any time from anywhere on the web.

Key Features of Amazon S3
Scalability

Stores unlimited data.
Automatically scales based on demand.
Durability & Availability

99.999999999% (11 nines) durability.
High availability with multiple availability zones.
Security

Data encryption (in-transit & at-rest).
IAM policies, bucket policies, ACLs for access control.
VPC endpoints for private access.
Storage Classes

S3 Standard – Frequent access, low latency.
S3 Intelligent-Tiering – Auto-moves data between tiers.
S3 Standard-IA – Infrequent access, lower cost.
S3 One Zone-IA – Single AZ storage, cost-effective.
S3 Glacier – Low-cost, long-term archive storage.
S3 Glacier Deep Archive – Cheapest, for long-term storage.
S3 Reduced Redundancy Storage (RRS) – Lower durability, rarely used.
Data Management & Lifecycle Policies

Automate data transfer between storage classes.
Expire/delete objects after a certain period.
Versioning

Keeps multiple versions of an object.
Helps recover from accidental deletion.
Replication

Same-Region Replication (SRR) – Within the same region.
Cross-Region Replication (CRR) – Across different regions.
Event Notifications

Triggers on PUT, POST, DELETE operations.
Can be integrated with Lambda, SNS, and SQS.
Query in Place

Amazon S3 Select – Queries data inside S3 without downloading.
Amazon Athena – SQL queries on S3 data.
Logging & Monitoring

Server Access Logs – Track requests.
AWS CloudTrail – Logs API calls.
Amazon CloudWatch – Monitors usage metrics.
Object Lock & Legal Hold
Prevents accidental deletion/modification.
Ideal for regulatory compliance.
Performance Optimization
Multipart Upload – Uploads large objects in parts.
Byte-Range Fetches – Retrieves specific byte ranges.
S3 Bucket Basics
Creating an S3 Bucket
Bucket names must be globally unique.
Region selection affects latency & costs.
Supports up to 100 buckets per account (by default).
Bucket Policies & Access Control
Bucket Policies – JSON-based rules for access control.
IAM Policies – Controls access for AWS users.
ACLs (Access Control Lists) – Grants permissions per object.
Pre-Signed URLs – Temporary access to objects.
S3 Pricing Model
Pricing is based on:

Storage Class – Standard, IA, Glacier, etc.
Data Transfer – Inbound (free), outbound (charged).
Requests & Retrievals – PUT, GET, DELETE, LIST.
Replication & Lifecycle Policies – Additional charges.
Common Use Cases
Static website hosting.
Backup & disaster recovery.
Big data analytics storage.
Content distribution via CloudFront.
Storing logs, media files, and IoT data.

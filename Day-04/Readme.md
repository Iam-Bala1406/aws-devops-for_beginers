What is a VPC (Virtual Private Cloud)?
A Virtual Private Cloud (VPC) is a logically isolated section of the AWS cloud where you can launch AWS resources in a secure, customizable virtual network. It allows you to define and control your network environment, including IP address ranges, subnets, route tables, internet connectivity, and security settings.

Key Components of a VPC
A VPC consists of several components that help manage networking in AWS:

1. CIDR Block (IP Address Range)
When creating a VPC, you specify an IP address range in the form of a CIDR block (e.g., 10.0.0.0/16).
The IP range must be within private IP ranges:
10.0.0.0 – 10.255.255.255 (10.0.0.0/8)
172.16.0.0 – 172.31.255.255 (172.16.0.0/12)
192.168.0.0 – 192.168.255.255 (192.168.0.0/16)
2. Subnets
A VPC can be divided into multiple subnets.
Each subnet must reside entirely within one Availability Zone (AZ).
Types of subnets:
Public Subnet: Has a route to the internet through an Internet Gateway (IGW).
Private Subnet: No direct internet access, used for internal resources.
Protected Subnet (optional): Used with NAT Gateway to allow outgoing internet traffic while blocking incoming traffic.
3. Internet Gateway (IGW)
An IGW enables communication between instances in a public subnet and the internet.
It is attached at the VPC level.
Works in combination with route tables to allow outbound and inbound traffic.
4. Route Tables
Route tables control where network traffic is directed.
Each subnet must be associated with a route table.
Key entries in a route table:
Local route (10.0.0.0/16 → local): Ensures communication within the VPC.
Internet route (0.0.0.0/0 → IGW): Allows external internet access for public subnets.
NAT route (0.0.0.0/0 → NAT Gateway): Provides outbound internet access for private subnets.
5. NAT Gateway / NAT Instance
NAT Gateway (Network Address Translation):
Allows instances in private subnets to access the internet (e.g., for software updates).
Prevents direct incoming traffic from the internet.
More scalable and managed than NAT instances.
NAT Instance (legacy):
An EC2 instance manually configured as a NAT.
Requires manual maintenance and scaling.
6. Security Groups (SG) & Network ACLs (NACLs)
Security Group (SG):
Instance-level firewall.
Controls inbound and outbound traffic.
Stateful (if an inbound rule allows traffic, the outbound response is automatically allowed).
Network ACL (NACL):
Subnet-level firewall.
Controls inbound and outbound traffic with rules.
Stateless (both inbound and outbound rules must be explicitly defined).
Feature	Security Group	NACL
Scope	Instance Level	Subnet Level
Default Rule	Deny All	Allow All
Statefulness	Stateful (Response traffic is allowed)	Stateless (Explicitly define both directions)
Rules Applied	Evaluates all rules	Rules processed in order
7. VPC Peering
VPC peering allows communication between two VPCs using private IP addresses.
Can be between different AWS accounts or regions.
Does not support transitive peering (A → B and B → C doesn’t mean A → C).
8. VPN & Direct Connect
AWS VPN (Virtual Private Network):
Securely connects an on-premises network to a VPC using an encrypted tunnel.
AWS Direct Connect:
Dedicated private connection from a data center to AWS.
Offers higher speeds and lower latency than a VPN.
9. VPC Endpoints
VPC Endpoint allows AWS services (like S3, DynamoDB) to be accessed privately without using an internet gateway.
Types of endpoints:
Interface Endpoint (Uses AWS PrivateLink)
Gateway Endpoint (For S3 & DynamoDB)
VPC Deployment Scenarios
1. Simple Public-Private Architecture
🔹 Public Subnet: EC2 instance with an Elastic IP + Internet Gateway.
🔹 Private Subnet: Database server (RDS) with no internet access.
🔹 NAT Gateway: Allows outbound traffic from private subnet.

2. Fully Private VPC (No Internet)
🔹 Only internal AWS services and on-premises access through VPN or Direct Connect.
🔹 Used for highly secure workloads.

3. Multi-VPC Strategy (Using Peering or Transit Gateway)
🔹 Multiple VPCs for different teams (e.g., Dev, Test, Prod).
🔹 Uses VPC Peering or Transit Gateway for communication.

Best Practices for VPC Design
✅ Use multiple Availability Zones for high availability.
✅ Separate public and private subnets (e.g., web servers in public, databases in private).
✅ Use Security Groups & NACLs to control traffic.
✅ Monitor network traffic using VPC Flow Logs.
✅ Use VPC Endpoints for AWS services to avoid internet traffic.
✅ Limit the CIDR block size (avoid /8, prefer /16 or /24 for better subnetting).

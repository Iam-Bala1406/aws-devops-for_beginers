Step-by-Step Guide to Creating a VPC in AWS
A Virtual Private Cloud (VPC) is a logically isolated network within AWS where you can launch your resources, such as EC2 instances, RDS databases, and more. Below are the detailed steps to create a VPC in AWS.

Step 1: Log in to AWS Console
Go to the AWS Management Console: AWS Console
Sign in with your AWS credentials.
Navigate to the VPC Dashboard:
In the search bar, type VPC and select VPC from the Services list.
Click Your VPCs on the left-hand menu.
Step 2: Create a New VPC
Click on Create VPC (blue button at the top right).
Choose VPC only (if you only want a VPC) or VPC and more (if you also want subnets, internet gateway, etc.).
Provide the following details:
Name tag: MyVPC (or any meaningful name)
IPv4 CIDR Block: 10.0.0.0/16 (You can define a different CIDR block as per requirement)
IPv6 CIDR Block: Choose No IPv6 CIDR Block (unless you need IPv6).
Tenancy: Select Default (Dedicated is costly).
Click Create VPC.
✅ Your VPC is now created!

Step 3: Create Subnets
A subnet allows you to divide your VPC into smaller networks. AWS best practice is to create at least two subnets (one public, one private) across different Availability Zones for high availability.

In the VPC Dashboard, click Subnets (on the left menu).
Click Create Subnet.
Fill in the details:
VPC ID: Select the VPC you created (MyVPC).
Subnet name: Public-Subnet-1
Availability Zone: Choose an AZ (e.g., us-east-1a).
IPv4 CIDR block: 10.0.1.0/24 (Subnetting from your VPC range).
Click Create Subnet.
💡 Repeat steps to create a private subnet:

Name: Private-Subnet-1
AZ: us-east-1b
CIDR Block: 10.0.2.0/24
✅ Your subnets are now created!

Step 4: Create an Internet Gateway (For Public Access)
An Internet Gateway (IGW) allows resources inside the VPC to communicate with the internet.

Go to Internet Gateways from the left panel.
Click Create Internet Gateway.
Provide a name: MyVPC-IGW.
Click Create Internet Gateway.
Attach IGW to your VPC:
Select MyVPC-IGW.
Click Actions → Attach to VPC.
Select MyVPC and Attach.
✅ Internet Gateway is now attached to your VPC!

Step 5: Create a Route Table (For Internet Access)
By default, AWS creates a main route table, but we need a custom one for the public subnet.

For Public Subnet (Allows Internet Access)
Click Route Tables in the left menu.
Click Create Route Table.
Provide a name: Public-RT.
Select VPC: Choose MyVPC.
Click Create Route Table.
Add a Route to Internet Gateway:
Click on the new route table (Public-RT).
Go to the Routes tab → Edit Routes.
Click Add Route:
Destination: 0.0.0.0/0 (For all internet traffic).
Target: Select Internet Gateway (MyVPC-IGW).
Click Save changes.
Associate Route Table with Public Subnet:
Click Subnet Associations → Edit Subnet Associations.
Select Public-Subnet-1.
Click Save.
✅ Now, your public subnet can access the internet!

Step 6: Create a NAT Gateway (For Private Subnet)
A NAT Gateway allows private subnet instances to access the internet (e.g., for software updates) without being exposed to inbound traffic.

Click NAT Gateways from the left panel.
Click Create NAT Gateway.
Provide a name: MyVPC-NAT.
Select Subnet: Choose Public-Subnet-1.
Elastic IP Allocation: Click Allocate Elastic IP → Select it.
Click Create NAT Gateway.
Update Private Route Table
Go to Route Tables → Click Create Route Table.
Name it Private-RT, select MyVPC, and click Create.
Add a Route to NAT Gateway:
Click Private-RT → Go to Routes → Edit Routes.
Add Route:
Destination: 0.0.0.0/0.
Target: Select NAT Gateway (MyVPC-NAT).
Click Save changes.
Associate with Private Subnet:
Click Subnet Associations → Edit Subnet Associations.
Select Private-Subnet-1.
Click Save.
✅ Now, instances in the private subnet can access the internet securely!

Step 7: Launch an EC2 Instance in the VPC
Go to EC2 Dashboard → Click Launch Instance.
Choose Amazon Linux 2 / Ubuntu.
Select VPC: Choose MyVPC.
Select Subnet: Choose Public-Subnet-1.
Enable Auto-assign Public IP (for internet access).
Choose Security Group (Allow SSH 22 and HTTP 80).
Click Launch and Connect via SSH:
bash
Copy
Edit
ssh -i /path/to/key.pem ec2-user@your-public-ip
✅ Your VPC is now fully functional with a public and private subnet! 🎉

Final VPC Architecture
java
Copy
Edit
AWS VPC (10.0.0.0/16)
│
├── Public Subnet (10.0.1.0/24)  → Internet Gateway (IGW)
│   ├── EC2 Instance (Has public IP, accessible)
│
├── Private Subnet (10.0.2.0/24) → NAT Gateway
│   ├── EC2 Instance (No public IP, but can access the internet)
│
└── Route Tables:
    ├── Public Route Table → 0.0.0.0/0 → IGW
    ├── Private Route Table → 0.0.0.0/0 → NAT Gateway
🎯 You have successfully created a custom AWS VPC with public and private subnets! 🚀
Let me know if you need any modifications! 😊

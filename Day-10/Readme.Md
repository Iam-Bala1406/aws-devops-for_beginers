What is AWS CloudFormation?
AWS CloudFormation is an Infrastructure as Code (IaC) service that allows you to define and provision AWS infrastructure using a declarative template in YAML or JSON. It automates resource creation, making deployments consistent, repeatable, and manageable.

CloudFormation Template Structure
A CloudFormation template consists of various sections, each serving a specific purpose. Below is a breakdown of its key components:

1. AWSTemplateFormatVersion (Optional)
Defines the version of the CloudFormation template format.
Currently, the only valid value is '2010-09-09'.
Example:

yaml
Copy
Edit
AWSTemplateFormatVersion: '2010-09-09'
2. Description (Optional)
A short description of the CloudFormation stack.
Example:

yaml
Copy
Edit
Description: "This template creates an S3 bucket with versioning enabled."
3. Metadata (Optional)
Provides additional information about the template.
Useful for documentation or IDE support.
Example:

yaml
Copy
Edit
Metadata:
  AWS::CloudFormation::Interface:
    ParameterGroups:
      - Label:
          default: "S3 Bucket Configuration"
        Parameters:
          - BucketName
4. Parameters (Optional)
Allows passing dynamic values into the template.
Reduces hardcoding, making templates reusable.
Supports data types like String, Number, List<String>, and AWS-specific types.
Example:

yaml
Copy
Edit
Parameters:
  BucketName:
    Type: String
    Description: "Name of the S3 bucket"
    Default: "my-cloudformation-bucket"
5. Mappings (Optional)
Defines static, key-value pair data.
Often used to map region-based AMI IDs.
Example:

yaml
Copy
Edit
Mappings:
  RegionMap:
    us-east-1:
      AMI: "ami-0abcdef1234567890"
    us-west-1:
      AMI: "ami-0fedcba9876543210"
6. Conditions (Optional)
Enables or disables resources based on conditions.
Useful when creating environments like Dev, Test, and Prod.
Example:

yaml
Copy
Edit
Conditions:
  IsProduction: !Equals [!Ref "EnvironmentType", "Production"]
7. Resources (Mandatory)
Defines AWS resources to create.
Each resource must have a logical name, type, and properties.
Example:

yaml
Copy
Edit
Resources:
  MyS3Bucket:
    Type: AWS::S3::Bucket
    Properties:
      BucketName: !Ref BucketName
      VersioningConfiguration:
        Status: Enabled
The Type specifies the AWS resource (AWS::S3::Bucket).
The Properties define the resource's configuration.
The !Ref function refers to the BucketName parameter.
8. Outputs (Optional)
Provides information about created resources.
Useful for exporting values to other stacks.
Example:

yaml
Copy
Edit
Outputs:
  S3BucketName:
    Description: "The name of the S3 bucket"
    Value: !Ref MyS3Bucket
9. Transforms (Optional)
Used for AWS Serverless Application Model (SAM) templates.
Enables shorthand syntax for Lambda, API Gateway, etc.
Example:

yaml
Copy
Edit
Transform: AWS::Serverless-2016-10-31
How CloudFormation Works?
Write a Template – Define AWS resources in a YAML/JSON file.
Upload to CloudFormation – Use AWS Console, CLI, or SDK to deploy.
CloudFormation Creates a Stack – Deploys and manages resources.
Update Stack – Modify resources by updating the template.
Delete Stack – Removes all associated resources.
Benefits of AWS CloudFormation
✅ Infrastructure as Code (IaC) – Automates provisioning.
✅ Consistency – Ensures the same resources every time.
✅ Rollback Support – Reverts changes if deployment fails.
✅ Stack Dependencies – Manages dependencies automatically.
✅ Cross-Region & Cross-Account – Deploys globally.

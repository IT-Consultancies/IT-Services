# IT-Services
## Creation of Databse
### Tables:
```
CREATE TABLE Customers (
  cus_id INT PRIMARY KEY,
  cus_name VARCHAR(255),
  cus_pass VARCHAR(255),
  cus_phone VARCHAR(20),
  cus_email VARCHAR(50),
  isSubscribed INT
);


CREATE TABLE Employee (
  employeeID INT PRIMARY KEY,
  name VARCHAR(255),
  password VARCHAR(255),
  ephone VARCHAR(255)
);




CREATE TABLE Service (
  serviceID INT PRIMARY KEY,
  serviceName VARCHAR(255)
);


CREATE TABLE Orders (
  orderID INT PRIMARY KEY AUTO_INCREMENT,
  userID INT,
  serviceID INT,
  employeeID INT,
  price INT,
  subService VARCHAR(20),
  FOREIGN KEY (userID) REFERENCES customers(cus_ID),
  FOREIGN KEY (serviceID) REFERENCES Service(serviceID),
  FOREIGN KEY (employeeID) REFERENCES Employee(employeeID)
);

ALTER TABLE employee
ADD COLUMN major_id INT,
ADD CONSTRAINT fk_major_id
  FOREIGN KEY (major_id)
  REFERENCES services (serviceID);

```
### Insertions:

```

INSERT INTO Customers (cus_id, cus_name, cus_pass, cus_phone, cus_email, isSubscribed)
VALUES
  (1, 'John Doe', 'password123', '1234567890', 'john@example.com', 0),
  (2, 'Jane Smith', 'password456', '9876543210', 'jane@example.com', 0),
  (3, 'David Johnson', 'password789', '5555555555', 'david@example.com', 0)

```





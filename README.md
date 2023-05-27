# IT-Services
## Creation of Databse
### Tables:
```
CREATE TABLE USERS (
  userID INT PRIMARY KEY,
  name VARCHAR(255),
  password VARCHAR(255),
  phone VARCHAR(20)
);

CREATE TABLE Employee (
  employeeID INT PRIMARY KEY,
  name VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE Service (
  serviceID INT PRIMARY KEY,
  serviceName VARCHAR(255),
  price DECIMAL(10, 2),
  subservice VARCHAR(255)
);

CREATE TABLE Order (
  orderID INT PRIMARY KEY,
  userID INT,
  adminID INT,
  serviceID INT,
  employeeID INT,
  FOREIGN KEY (userID) REFERENCES Users(userID),
  FOREIGN KEY (adminID) REFERENCES Admin(adminID),
  FOREIGN KEY (serviceID) REFERENCES Service(serviceID),
  FOREIGN KEY (employeeID) REFERENCES Employee(employeeID)
);

```
### Insertions:

```

INSERT INTO USERS (userID, name, password, phone)
VALUES (101, 'Ahmed', '1212', '0501212');

INSERT INTO USERS (userID, name, password, phone)
VALUES (102, 'Mohammed', '1812', '0501122');

INSERT INTO Employee (employeeID, name, password)
VALUES (01, 'Bader', '0101');

INSERT INTO Employee (employeeID, name, password)
VALUES (02, 'Malek', '0202');

INSERT INTO Employee (employeeID, name, password)
VALUES (03, 'Mohammed', '0303');

INSERT INTO Employee (employeeID, name, password)
VALUES (04, 'Firas', '0404');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (71, 'Network', 600, 'Network Implementation');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (72, 'Network', 600, 'Network Configuration');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (73, 'Network', 600, 'Network Design');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (51, 'Cloud', 1200, 'Cloud Implementation');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (52, 'Cloud', 1200, 'Cloud Configuration');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (53, 'Cloud', 1200, 'Cloud Design');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (91, 'Security', 1600, 'Security Implementation');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (92, 'Security', 1600, 'Security Configuration');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (93, 'Security', 1600, 'Security Design');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (41, 'Database', 1800, 'Database Implementation');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (42, 'Database', 1800, 'Database Configuration');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (43, 'Database', 1800, 'Database Design');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (31, 'Server', 500, 'Server Implementation');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (32, 'Server', 500, 'Server Configuration');

INSERT INTO Service (serviceID, serviceName, price, subservice)
VALUES (33, 'Server', 500, 'Server Design');

```





CREATE TABLE customers  
( customer_id number(10) NOT NULL PRIMARY KEY,  
  customer_name varchar2(50) NOT NULL,  
  phone_number number(10)  
);

CREATE SEQUENCE Customers_sequence
START WITH 1
INCREMENT BY 1;

CREATE TABLE Orders (
    Order_Id Number(4) NOT NULL,
    Customer_Id Number(4) NOT NULL,
    Order_Date date,
    PRIMARY KEY (Order_Id),
    FOREIGN KEY (Customer_Id) REFERENCES customers(Customer_Id)
);

CREATE TABLE orderTransaction (
    OrderTran_ID Number(4) NOT NULL,
    order_ID Number(4) NOT NULL,
    Coffee_ID Number(4),
    AddOn_Id Number(4),
    PRIMARY KEY (OrderTran_ID),
     FOREIGN KEY (order_ID) REFERENCES orders(order_ID),
     FOREIGN KEY (Coffee_ID) REFERENCES coffee(Coffee_ID)
);


CREATE TABLE invoices (
    Invoice_No Number(4) NOT NULL,
    order_ID number(4) NOT NULL,
    Net_value Number(6,2),
    GST Number(6,2),
    Service_Tax Number(6,2),
    total Number(6,2),
    Price Number(6,2),
    Voucher_discount Number(6,2),  
    PRIMARY KEY (Invoice_No),
     FOREIGN KEY (order_ID) REFERENCES orders(order_ID)
);


CREATE TABLE COFFEE (
    Coffee_id Number(4) NOT NULL,
    Coffee_name varchar2(20) NOT NULL,
    Coffee_size varchar2(20),
    Coffee_Price Number(4),
    PRIMARY KEY (Coffee_id)
);


CREATE TABLE ADDON (
    AddOn_ID Number(4) NOT NULL,
    AddOn_Name varchar2(20) NOT NULL,
    AddOn_Price Number(4),
    PRIMARY KEY (AddOn_ID)
);


CREATE TABLE Vouchers (
    Voucher_ID Number(4) NOT NULL,
    Voucher_Name varchar2(20) NOT NULL,
    Voucher_discount Number(4,2),
    PRIMARY KEY (Voucher_ID)
);


INSERT INTO Customers (customer_id, customer_name, phone_number)
VALUES ('101', 'Jincy', '9786564738');
INSERT INTO Customers (customer_id, customer_name, phone_number)
VALUES ('102', 'Deepak', '9786564731');
INSERT INTO Customers (customer_id, customer_name, phone_number)
VALUES ('103', 'Anjali', '9786564732');
INSERT INTO Customers (customer_id, customer_name, phone_number)
VALUES ('104', 'Isha', '9786564733');


INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('1', 'CAPPUCINO', 'LARGE','140');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('2', 'CAPPUCINO', 'REGULAR','110');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('3', 'CAPPUCINO', 'SMALL','90');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('4', 'EXPRESSO', 'LARGE','220');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('5', 'EXPRESSO', 'REGULAR','170');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('6', 'EXPRESSO', 'SMALL','110');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('7', 'LATTE', 'LARGE','190');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('8', 'LATTE', 'REGULAR','140');
INSERT INTO COFFEE (COFFEE_ID, COFFEE_NAME, COFFEE_SIZE,COFFEE_PRICE)
VALUES ('9', 'LATTE', 'SMALL','90');

INSERT INTO ADDON (ADDON_ID, ADDON_NAME, ADDON_PRICE)
VALUES ('1', 'CHOCOLATE', '30');
INSERT INTO ADDON (ADDON_ID, ADDON_NAME, ADDON_PRICE)
VALUES ('2', 'CREAM', '50');
INSERT INTO ADDON (ADDON_ID, ADDON_NAME, ADDON_PRICE)
VALUES ('3', 'HAZELNUT', '30');
INSERT INTO ADDON (ADDON_ID, ADDON_NAME, ADDON_PRICE)
VALUES ('4', 'ALMOND', '40');

INSERT INTO Vouchers (Voucher_ID, Voucher_Name, Voucher_discount)
VALUES ('1', 'AAAAA', 5');




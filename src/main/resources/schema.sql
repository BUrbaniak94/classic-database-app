CREATE SCHEMA classicmodels; 
USE classicmodels;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 192.168.99.100    Database: classicmodels
-- ------------------------------------------------------
-- Server version	8.0.20












--
-- Table structure for table customers
--

DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  customer_number int NOT NULL,
  customer_name varchar(50) NOT NULL,
  contact_last_name varchar(50) NOT NULL,
  contact_first_name varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  address_line1 varchar(50) NOT NULL,
  address_line2 varchar(50) DEFAULT NULL,
  city varchar(50) NOT NULL,
  state varchar(50) DEFAULT NULL,
  postal_code varchar(15) DEFAULT NULL,
  country varchar(50) NOT NULL,
  sales_rep_employee_number int DEFAULT '0',
  credit_limit decimal(10,2) DEFAULT '0.00');

--
-- Table structure for table employees
--

DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  employee_number int NOT NULL,
  last_name varchar(50) NOT NULL,
  first_name varchar(50) NOT NULL,
  extension varchar(10) NOT NULL,
  email varchar(100) NOT NULL,
  office_code varchar(10) NOT NULL,
  reports_to int DEFAULT NULL,
  job_title varchar(50) NOT NULL);

--
-- Table structure for table hibernate_sequence
--

DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE hibernate_sequence (
  next_val bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table offices
--

DROP TABLE IF EXISTS offices;

CREATE TABLE offices (
  office_code varchar(10) NOT NULL,
  city varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  address_line1 varchar(50) NOT NULL,
  address_line2 varchar(50) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  country varchar(50) NOT NULL,
  postal_code varchar(15) NOT NULL,
  territory varchar(10) NOT NULL);

--
-- Table structure for table orderdetails
--

DROP TABLE IF EXISTS orderdetails;

CREATE TABLE orderdetails (
  order_number int NOT NULL,
  product_code varchar(15) NOT NULL,
  quantity_ordered int NOT NULL,
  price_each decimal(10,2) NOT NULL,
  order_line_number smallint NOT NULL);

--
-- Table structure for table orders
--

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  order_number int NOT NULL,
  order_date date NOT NULL,
  required_date date NOT NULL,
  shipped_date date DEFAULT NULL,
  status varchar(15) NOT NULL,
  comments text,
  customer_number int NOT NULL);

--
-- Table structure for table payments
--

DROP TABLE IF EXISTS payments;

CREATE TABLE payments (
  customer_number int NOT NULL,
  check_number varchar(50) NOT NULL,
  payment_date date NOT NULL,
  amount decimal(10,2) NOT NULL);

--
-- Table structure for table productlines
--

DROP TABLE IF EXISTS productlines;

CREATE TABLE productlines (
  product_line varchar(50) NOT NULL,
  text_description varchar(4000) DEFAULT NULL,
  html_description mediumtext,
  image mediumblob);

--
-- Table structure for table products
--

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  product_code varchar(15) NOT NULL,
  product_name varchar(70) NOT NULL,
  product_line varchar(50) NOT NULL,
  product_scale varchar(10) NOT NULL,
  product_vendor varchar(50) NOT NULL,
  product_description text NOT NULL,
  quantity_in_stock smallint NOT NULL,
  buy_price decimal(10,2) NOT NULL,
  MSRP decimal(10,2) NOT NULL);

-- Dump completed on 2021-01-18 19:46:29;



ALTER TABLE customers ADD PRIMARY KEY (customer_number);
ALTER TABLE employees ADD PRIMARY KEY (employee_number);
ALTER TABLE employees ADD FOREIGN KEY (reports_to) REFERENCES employees (employee_number);
ALTER TABLE employees ADD FOREIGN KEY (office_code) REFERENCES offices (office_code);
ALTER TABLE offices ADD PRIMARY KEY (office_code);
ALTER TABLE orderdetails ADD PRIMARY KEY (order_number, product_code);
ALTER TABLE orderdetails ADD FOREIGN KEY (order_number) REFERENCES orders (order_number);
ALTER TABLE orderdetails ADD FOREIGN KEY (product_code) REFERENCES products (product_code);
ALTER TABLE orders ADD PRIMARY KEY (order_number);
ALTER TABLE orders ADD FOREIGN KEY (customer_number) REFERENCES customers (customer_number);
ALTER TABLE payments ADD PRIMARY KEY (customer_number, check_number);
ALTER TABLE payments ADD FOREIGN KEY (customer_number) REFERENCES customers (customer_number);
ALTER TABLE productlines ADD PRIMARY KEY (product_line);
ALTER TABLE products ADD PRIMARY KEY (product_code);
ALTER TABLE products ADD FOREIGN KEY (product_line) REFERENCES productlines (product_line);
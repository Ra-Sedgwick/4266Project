DROP DATABASE IF EXISTS just_pedlas;
CREATE DATABASE IF NOT EXISTS just_pedals;
USE just_pedals;

-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS User;
CREATE TABLE User (
  UserID int(11) NOT NULL AUTO_INCREMENT,
  LastName varchar(50) DEFAULT NULL,
  FirstName varchar(50) DEFAULT NULL,
  Email varchar(50) DEFAULT NULL,
  Address_1 varchar(50) DEFAULT NULL,
  Address_2 varchar(50) NOT NULL,
  City varchar(50) DEFAULT NULL,
  State varchar(50) DEFAULT NULL,
  Postal_Code int(11) DEFAULT NULL,
  Country varchar(50) DEFAULT NULL,
  Password varchar(50) NOT NULL,
  PRIMARY KEY (`UserID`)
);


-- ----------------------------
--  Table structure for `Product`
-- ----------------------------
DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
  ProductCode int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(50) DEFAULT NULL,
  CatelogCategory varchar(50) DEFAULT NULL,
  Description varchar(255) DEFAULT NULL,
  Price decimal(10,2) DEFAULT NULL,
  ImageURL varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ProductCode`)
);	

INSERT INTO User (
	LastName,
    FirstName,
    Email,
    Address_1,
    Address_2,
    City,
    State,
    Postal_Code,
    Country,
    Password)
Values (
	'Smith',
    'John',
    'Jsmith@earthlink.org',
    '123 Fake street',
    'Apt 1',
    'Charlotte',
    'North Carolina',
    '55555',
    'USA', 
    'toor'
);

INSERT INTO Product (
    Name,
    CatelogCategory,
    Description,
    Price,
    ImageURL
) 
VALUES (
    'Shimano',
    'clipless',
	'Shimano Ultegra PD-6800 SPD-SL Carbon Road Pedal',
    199.99,
	'images/ShimanoClipless.jpg'
 );
     
     
INSERT INTO Product (
    Name,
    CatelogCategory,
    Description,
    Price,
    ImageURL
) 
VALUES (
    'Crank Brothers',
    'clipless',
    'CrankBrothers Candy 2 Pedals',
	55.99,
     'images/CrankBrothersClipless.jpg'
 );
 
 INSERT INTO Product (
    Name,
    CatelogCategory,
    Description,
    Price,
    ImageURL
) 
VALUES (
    'Look',
    'clipless',
    'Look Keo Classic 3',
    40.64,
    'images/LookClipless.jpg'
 );
 
 INSERT INTO Product (
    Name,
    CatelogCategory,
    Description,
    Price,
    ImageURL
) 
VALUES (
    'Crank Brothers',
    'platform',
    'CrankBrothers 5050 Flat Pedals',
    120.00,
    'images/CrankBrothersPlatform.jpg'
);
 
 INSERT INTO Product (
    Name,
    CatelogCategory,
    Description,
    Price,
    ImageURL
) 
VALUES (
    'Shimano',
    'platform',
    'Shimano Saint MX80',
    89.50,
	'images/ShimanPlatform.jpg'
 );
 
  INSERT INTO Product (
    Name,
    CatelogCategory,
    Description,
    Price,
    ImageURL
) 
VALUES (
    'DMR',
    'platform',
    'DRM v12 Alloy Pedals',
     53.30,
     'images/DRMPlatform.jpg'
 )

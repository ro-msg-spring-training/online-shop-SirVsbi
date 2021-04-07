CREATE TABLE IF NOT EXISTS `Address`
(
    AddressId IDENTITY NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Country   VARCHAR(255),
    City      VARCHAR(255),
    County    VARCHAR(255),
    Street    VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `Location`
(
    LocationId IDENTITY NOT NULL PRIMARY KEY,
    Name       VARCHAR(255),
    AddressId  BIGINT,
    CONSTRAINT FK_LOCATION_ADDRESS FOREIGN KEY (AddressId) REFERENCES Address (AddressId)

);

CREATE TABLE IF NOT EXISTS `Stock`
(
    ProductId  BIGINT NOT NULL,
    LocationId BIGINT NOT NULL,
    Quantity   INT,
    PRIMARY KEY (ProductId, LocationId),
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (ProductId) REFERENCES Product (ProductId),
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY (LocationId) REFERENCES Location (LocationId)
);

CREATE TABLE IF NOT EXISTS `Customer`
(
    CustomerId   IDENTITY NOT NULL PRIMARY KEY,
    FirstName    VARCHAR(255),
    LastName     VARCHAR(255),
    UserName     VARCHAR(255),
    PasswordHash VARCHAR(255),
    EmailAddress VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `Order`
(
    OrderId    IDENTITY NOT NULL PRIMARY KEY,
    LocationId BIGINT,
    CustomerId BIGINT,
    CreatedAt  DATETIME2,
    AddressId  BIGINT,
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (LocationId) REFERENCES Location (LocationId),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId),
    CONSTRAINT FK_ORDER_ADDRESS FOREIGN KEY (AddressId) REFERENCES Address (AddressId)
);

CREATE TABLE IF NOT EXISTS `Revenue`
(
    RevenueId  IDENTITY NOT NULL PRIMARY KEY,
    LocationId BIGINT,
    Date       DATETIME2,
    Sum        DECIMAL,
    CONSTRAINT FK_REVENUE_LOCATION FOREIGN KEY (LocationId) REFERENCES Location (LocationId)


);

CREATE TABLE IF NOT EXISTS `Supplier`
(
    SupplierId IDENTITY NOT NULL PRIMARY KEY,
    Name       VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `ProductCategory`
(
    ProductCategoryId IDENTITY NOT NULL PRIMARY KEY,
    Name              VARCHAR(255),
    Description       VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `Product`
(
    ProductId         IDENTITY NOT NULL PRIMARY KEY,
    Name              VARCHAR(255),
    Description       VARCHAR(255),
    Price             DECIMAL, //BigDecimal(Java) -> Decimal(sql/H2)
    Weight            Double,
    ProductCategoryId BIGINT   ,
    SupplierId        BIGINT   ,
    ImageUrl          VARCHAR(255),
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (ProductCategoryId) references ProductCategory (ProductCategoryId),
    CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY (SupplierId) references Supplier (SupplierId)
)





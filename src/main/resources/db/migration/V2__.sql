CREATE TABLE category
(
    id         BIGINT           NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    is_deleted BIT(1) DEFAULT 0 NOT NULL,
    name       VARCHAR(255)     NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_top_products
(
    category_id     BIGINT NOT NULL,
    top_products_id BIGINT NOT NULL
);

CREATE TABLE product
(
    id            BIGINT           NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) DEFAULT 0 NOT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price DOUBLE NULL,
    quantity      INT NULL,
    image_url     VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE category_top_products
    ADD CONSTRAINT uc_category_top_products_topproducts UNIQUE (top_products_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_top_products
    ADD CONSTRAINT fk_cattoppro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_top_products
    ADD CONSTRAINT fk_cattoppro_on_product FOREIGN KEY (top_products_id) REFERENCES product (id);
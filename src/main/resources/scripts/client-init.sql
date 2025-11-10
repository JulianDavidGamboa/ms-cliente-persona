-- Se ejecuta en ambas bases
CREATE TABLE IF NOT EXISTS client_entity (
     client_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    gender VARCHAR(50),
    age INTEGER,
    identification VARCHAR(50),
    address VARCHAR(255),
    phone VARCHAR(50),
    password VARCHAR(255),
    active BOOLEAN
);

CREATE TABLE IF NOT EXISTS account_entity (
    account_number VARCHAR(255) PRIMARY KEY,
    account_type VARCHAR(50),
    initial_balance DOUBLE PRECISION,
    balance DOUBLE PRECISION,
    active BOOLEAN,
    client_id VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS transaction_entity (
    transaction_id VARCHAR(255) PRIMARY KEY,
    date TIMESTAMP,
    type VARCHAR(50),
    amount DOUBLE PRECISION,
    balance_after DOUBLE PRECISION,
    account_number VARCHAR(255),
    FOREIGN KEY (account_number) REFERENCES account_entity(account_number)
);

CREATE TABLE IF NOT EXISTS client_projection (
    client_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255)
);
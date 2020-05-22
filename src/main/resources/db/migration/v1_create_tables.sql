CREATE TABLE IF NOT EXISTS user (
    username VARCHAR(30) UNIQUE NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS user_account (
    username VARCHAR(30) UNIQUE NOT NULL PRIMARY KEY,
    balance FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS transaction (
    id SERIAL,
    from_user VARCHAR(30),
    to_user VARCHAR(30),
    transaction_type VARCHAR(20),
    amount FLOAT,
    transaction_date TIMESTAMP
);
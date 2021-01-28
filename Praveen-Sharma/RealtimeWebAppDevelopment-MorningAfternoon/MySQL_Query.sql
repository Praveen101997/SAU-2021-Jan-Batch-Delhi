drop database bankserver;
create database BankServer;
use BankServer;
Create table users (
	username varchar(20),
    account_number int primary key
);
				   
create table transactions(
	transaction_number SERIAL primary key,
	account_number int,
	note_serial_Number int,
	legal boolean
);

create table currency(
	note_serial_number int primary key,
	note_amount int
);


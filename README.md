# Core Banking Application

A banking applicaiton that include some functionalities of banking system such as Account Management, Transaction Management and Transaction History. This does not include core security of the banking system.

#### Features

- Account Management (Account information, Create Account, Update Account, Delete Account)
- Transaction Management (Deposit, Withdrawal, Transfer and Payment)
- Transaction History

#### Installation

```bash

git clone https://github.com/Re4ch-Jay/Banking-System.git

```

Then open in your favorite IDE e.g. VS Code, IntelliJ IDEA.

#### API Setup

Using your favorite API testing tool e.g Postman.

#### Account Management

Get One Account

GET: api/accounts/1

Sample Data
```json
{
    "message": "Successfully find the account",
    "accountId": 1,
    "firstName": "Panhareach",
    "lastName": "Phat",
    "balance": 550.0,
    "statusCode": 200,
    "date": "2023-11-22T06:25:38.797+00:00"
}
```

Create account

POST: api/accounts

```json

{
    "firstName": "Panhareach",
    "lastName": "Phat",
    "balance": 300.00
}

```

Update account

PUT: api/accounts/1

```json

{
    "firstName": "Panhareach",
    "lastName": "Phat"
}

```

Delete account

DELETE: api/accounts/1

#### Transaction Management

Make Deposit
api/accounts/1/deposit

```json

{
    "amount": 1000.00
}

```

Make Withdraw
api/accounts/1/withdraw

```json

{
    "amount": 1000.00
}

```

Make Transfer
api/accounts/1/transfer

```json

{
    "receiverId": 1,
    "amount": 60.00
}

```

Make Payment
api/accounts/1/payment

```json

{
    "receiverId": 1,
    "amount": 60.00
}

```

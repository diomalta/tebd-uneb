USE master
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
  SELECT name
    FROM sys.databases
    WHERE name = N'congresso'
)
CREATE DATABASE congresso
GO

-- Create a new table called 'TableName' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('congresso.migration', 'U') IS NOT NULL
DROP TABLE congresso.migration
GO

-- Create the table in the specified schema
CREATE TABLE migration (
  id int(10) PRIMARY KEY NOT NULL,
  state BOOLEAN NOT NULL
);
GO

-- Create a new table called 'TableName' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('congresso.address', 'U') IS NOT NULL
DROP TABLE congresso.address
GO

-- Create the table in the specified schema
CREATE TABLE address (
  id int(10) PRIMARY KEY NOT NULL,
  address VARCHAR(50) NOT NULL,
  cep VARCHAR(10)
);
GO

